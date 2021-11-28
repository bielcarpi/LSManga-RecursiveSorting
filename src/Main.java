
/**
 * Main Class
 *
 * @author bielcarpi
 * @version 1.0
 */
public class Main {

    public static void main(String[] args){
        SeriesManager seriesManager = SeriesManager.getSeriesManager();
        seriesManager.generateDataset(Dataset.XXXXL);
        seriesManager.orderLoadedDataset(SeriesManager.SeriesComparator.BY_POPULARITY, SortUtility.SortType.BUCKET_SORT);
        //seriesManager.printSeriesLoaded();
    }

}
