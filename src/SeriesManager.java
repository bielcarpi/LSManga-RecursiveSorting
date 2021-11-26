
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
