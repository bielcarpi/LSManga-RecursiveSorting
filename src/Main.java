
/**
 * Main Class
 *
 * @author bielcarpi
 * @version 1.0
 */
public class Main {

    public static void main(String[] args){
        SeriesManager seriesManager = SeriesManager.getSeriesManager();
        seriesManager.loadDataset(Dataset.S);
    }

}
