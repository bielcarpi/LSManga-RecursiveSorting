import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;

/**
 * The {@code SeriesManager} class will be able to read/write series from/to files and perform operations with them
 * @see Series
 *
 * @author bielcarpi
 * @version 1.0
 */
public class SeriesManager {
    private static SeriesManager seriesManager; //Singleton of the class
    private Series[] series;

    public enum SeriesComparator{
        BY_POPULARITY, //First the ones with higher popularity
        BY_PREMIERE_DATE, //First the ones with older premiere date
        BY_TOTAL_SCORE //First the ones with higher total score
    }

    /**
     * Default Constructor
     * <p>Private as we want this class to be a singleton
     */
    private SeriesManager(){}

    /**
     * Returns the singleton instance of SeriesManager
     * @return Singleton of this class
     */
    public static SeriesManager getSeriesManager() {
        if(seriesManager == null) seriesManager = new SeriesManager();
        return seriesManager;
    }


    /**
     * Reads a Dataset from the correspondent file in the system
     * <p>If the file doesn't exist, an error will be printed
     * @param ds The Dataset we want to read from
     *
     * @see Dataset
     */
    public void loadDataset(Dataset ds){
        try{
            BufferedReader br = new BufferedReader(new FileReader(ds.path));
            Gson gson = new Gson();
            SeriesObject seriesObject = gson.fromJson(br, SeriesObject.class);
            this.series = seriesObject.series;

            //Sanitize all series (just in case)
            for(Series serie: series)
                serie.sanitize();

            br.close();

        }catch(IOException e){
            System.err.println("Error. The dataset " + ds.name() + " doesn't exist or can't be read.");
            e.printStackTrace();
        }catch(JsonSyntaxException e){
            System.err.println("Error. The dataset " + ds.name() + " is not properly formatted.");
            e.printStackTrace();
        }

    }

    /**
     * Inner class so as to match the JSON format
     */
    private class SeriesObject{
        Series[] series;
    }



    /**
     * Generates a Dataset with the correspondent file in the system.
     * <p>The dataset generated will be already loaded, without the need of calling {@link #loadDataset(Dataset)}
     * <p>If the file already exists, its contents will be deleted
     * @param ds The Dataset we want to generate
     *
     * @see Dataset
     */
    public void generateDataset(Dataset ds){
        series = new Series[ds.numElements];

        //Create all new Series to fill the series array
        for(int i = 0; i < series.length; i++)
            series[i] = new Series(SeriesGenerator.getTitles(), SeriesGenerator.getAudience(), SeriesGenerator.getType(), SeriesGenerator.getGenres(), SeriesGenerator.getPremiereDate());

        //Write them on a file
        try{
            SeriesObject seriesObject = new SeriesObject();
            seriesObject.series = series;

            BufferedWriter bw = new BufferedWriter(new FileWriter(ds.path));
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); //We want the gson.toJson() method to give us a beautified JSON

            bw.write(gson.toJson(seriesObject));
            bw.close();

        }catch(IOException e){
            System.err.println("Error. The dataset " + ds.name() + " has been generated (it is loaded) but can't be written.");
            e.printStackTrace();
        }
    }


    /**
     * Writes a file with the current loaded Dataset
     * <p>If the file already exists, its contents will be deleted
     *
     * @see Dataset
     */
    public void writeCurrentDataset(){
        //Let's find what dataset we have currently loaded
        Dataset currentDataset = Dataset.L; //If none matches, by default we'll write to the L dataset
        for(Dataset d: Dataset.values())
            if(d.numElements == series.length) currentDataset = d;

        //Write all series on a file
        try{
            SeriesObject seriesObject = new SeriesObject();
            seriesObject.series = series;

            BufferedWriter bw = new BufferedWriter(new FileWriter(currentDataset.path));
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); //We want the gson.toJson() method to give us a beautified JSON

            bw.write(gson.toJson(seriesObject));
            bw.close();

        }catch(IOException e){
            System.err.println("Error. The dataset " + currentDataset.name() + " can't be written");
            e.printStackTrace();
        }
    }


    /**
     * Orders the current dataset loaded with Merge Sort
     */
    public void orderLoadedDatasetWithMergeSort(){
        System.out.println("Ordering dataset of size " + series.length + " with Merge Sort...");
        long startTime = System.nanoTime();
        series = SortUtility.mergeSort(series, new PopularityComparator());
        long endTime = System.nanoTime();

        System.out.println("Done! " + series.length + " elements ordered in " +
                new DecimalFormat("#.##").format(((endTime-startTime)/1000000000.0)) + " seconds.");
    }

    /**
     * Orders the current dataset loaded with Quicksort
     */
    public void orderLoadedDatasetWithQuicksort(){
        System.out.println("Ordering dataset of size " + series.length + " with Quicksort...");
        long startTime = System.nanoTime();
        SortUtility.quickSort(series, new PopularityComparator());
        long endTime = System.nanoTime();

        System.out.println("Done! " + series.length + " elements ordered in " +
                new DecimalFormat("#.##").format(((endTime-startTime)/1000000000.0)) + " seconds.");
    }


    /**
     * Prints on {@code stdin} all the Series currently loaded
     */
    public void printSeriesLoaded(){
        for(int i = 0; i< series.length; i++)
            System.out.println(i + " -> " + series[i].toString());
    }


    private static class PopularityComparator implements Comparator<Series> {
        @Override
        public int compare(Series s1, Series s2) {
            return Integer.compare(s1.getPopularity(), s2.getPopularity());
        }
    }

    private static class TotalScoreComparator implements Comparator<Series> {
        @Override
        public int compare(Series s1, Series s2) {
            return Integer.compare(s1.getTotalScore(), s2.getTotalScore());
        }
    }

    private static class PremiereDateComparator implements Comparator<Series> {
        @Override
        public int compare(Series s1, Series s2){
            return s1.getPremiereDate().compareTo(s2.getPremiereDate());
        }
    }


}
