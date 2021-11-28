import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Calendar;

/**
 * The {@code Series} class will be in charge of saving a Series together with its attributes, such as its diferent Titles, popularity, averageScore, etc.
 * <p>If a Series is deserialized with Gson, {@link #sanitize()} must be called before that. If not, the class can not work as expected.
 *
 * @see Series#Series(String[], int[], String, String[], int[]) 
 *
 * @author bielcarpi
 * @version 1.0
 */
public class Series {

    private SeriesTitle title;
    private int popularity;
    private int averageScore;
    private int favourites;
    private String type;
    private String[] genres;
    private SeriesStartDate startDate;

    private transient int totalScore;


    /**
     * SeriesTitle Class.
     * Will be used for saving the different titles of a Series
     */
    private class SeriesTitle {
        @SerializedName("romaji")
        String romajiTitle;
        @SerializedName("english")
        String englishTitle;
        @SerializedName("native")
        String nativeTitle;

        SeriesTitle(String romajiTitle, String englishTitle, String nativeTitle){
            this.romajiTitle = romajiTitle;
            this.englishTitle = englishTitle;
            this.nativeTitle = nativeTitle;
        }
    }

    private class SeriesStartDate {
        int year, month, day;
        transient Calendar calendar;

        SeriesStartDate(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }

    /**
     * Default Series Constructor
     * @param titles Array containing the titles of the Series in romaji, english and native
     * @param audience Array containing the popularity, averageScore and favourites of the Series
     * @param type The Type of Series. Either "MANGA" or "ANIME"
     * @param genres Array with different generes that this Series represents
     * @param yearMonthDate Array containing the year, month and date of the premiere of this Series
     */
    public Series(String[] titles, int[] audience, String type, String[] genres, int[] yearMonthDate){
        title = new SeriesTitle(titles[0], titles[1], titles[2]);
        this.popularity = audience[0];
        this.averageScore = audience[1];
        this.favourites = audience[2];
        this.type = type;
        this.genres = genres;
        startDate = new SeriesStartDate(yearMonthDate[0], yearMonthDate[1], yearMonthDate[2]);

        sanitize();
        totalScore = (int)(0.4*popularity + 0.2*favourites + 0.4*averageScore);
    }


    /**
     * Whenever a Series has been read from a file, its fields should be sanitized.
     * Call this method for ensure a proper sanitizing of all Series attributes
     */
    public void sanitize(){
        //Sanitize day/month/year
        if(startDate.day < 1 || startDate.day > 31)
            startDate.day = 1;
        if(startDate.month < 1 || startDate.month > 12)
            startDate.month = 1;
        if(startDate.year < 1930 || startDate.year > 2100)
            startDate.year = 1970;

        //Create calendar with current sanitized values
        startDate.calendar = Calendar.getInstance();
        startDate.calendar.set(startDate.year, startDate.month, startDate.day);

        //Sanitize other fields: popularity, avgScore, favourites and type
        if(popularity < 0) popularity = 0;
        if(averageScore < 0) averageScore = 0;
        if(favourites < 0) favourites = 0;
        if(favourites > popularity) favourites = popularity;
        if(!type.equals("MANGA") && !type.equals("ANIME")) type = null;
    }

    /**
     * Returns the popularity (number of people that have seen this Series)
     * @return Number of people that have seen this Series
     */
    public int getPopularity(){
        return popularity;
    }

    /**
     * Returns the totalScore of this series
     * <p>This number will be generated taking into account popularity, avg score and favourites
     * @return Total Score of this Series
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Returns the premiere date of this Series
     * @return Premiere date of this Series
     * @see Calendar
     */
    public Calendar getPremiereDate() {
        return startDate.calendar;
    }


    @Override
    public String toString() {
        return "Series{" +
                "englishTitle=" + title.englishTitle +
                ", popularity=" + popularity +
                ", averageScore=" + averageScore +
                ", favourites=" + favourites +
                ", type='" + type + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", startDate=" + startDate.day + "/" + startDate.month + "/" + startDate.year +
                '}';
    }
}
