import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
     * Generates a Dataset with the correspondent file in the system
     * <p>If the file already exists, its contents will be deleted
     * @param ds The Dataset we want to generate
     *
     * @see Dataset
     */
    public void generateDataset(Dataset ds){

    }

}
