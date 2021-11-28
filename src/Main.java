
/**
 * Main Class
 *
 * @author bielcarpi
 * @version 1.0
 */
public class Main {

    public static void main(String[] args){
        //Get Instance of the SeriesManager class. It will provide methods for generating, loading, writing and ordering datasets
        SeriesManager seriesManager = SeriesManager.getSeriesManager();

        //There are 7 types of datasets: S, M, L, XL, ..., XXXXL (see the Datset enum)
        seriesManager.generateDataset(Dataset.XXXXL); //Generate a dataset, load it into memory and write it
        //seriesManager.loadDataset(Dataset.S); //Or load an already created dataset

        //Order the loaded dataset with a comparator (By popularity, premiere date or total score) and one of the
        //  sorting algorithms (either merge sort, quicksort or bucket sort).
        //  Take into account that Bucketsort can only order By Popularity. The other algorithms, can order by any comparator.
        seriesManager.orderLoadedDataset(SeriesManager.SeriesComparator.BY_POPULARITY, SortUtility.SortType.QUICKSORT);

        //seriesManager.printSeriesLoaded(); //Either print the ordered series on stdin
        //seriesManager.writeCurrentDataset(); //Or write the ordered series on its file
    }

}
