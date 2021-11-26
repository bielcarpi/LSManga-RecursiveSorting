import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * The {@code Series} class will be in charge of saving a Series together with its attributes, such as its diferent Titles, popularity, averageScore, etc.
 * @see Series#Series(String, String, String, int, int, int, String, String[], int, int, int)
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

        SeriesStartDate(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }

    /**
     * Default Series Constructor
     * @param romajiTitle The Title of the Series in Romaji
     * @param englishTitle The Title of the Series in English
     * @param nativeTitle The Title of the Series in native
     * @param popularity How many people have seen this Series
     * @param averageScore The average score of the people
     * @param favourites How many people marked this Series as favourite
     * @param type The Type of Series. Either "MANGA" or "ANIME"
     * @param genres Array with different generes that this Series represents
     * @param year Year of premiere
     * @param month Month of premiere
     * @param day Day of premiere
     */
    public Series(String romajiTitle, String englishTitle, String nativeTitle, int popularity, int averageScore, int favourites, String type, String[] genres, int year, int month, int day){
        title = new SeriesTitle(romajiTitle, englishTitle, nativeTitle);
        this.popularity = popularity;
        this.averageScore = averageScore;
        this.favourites = favourites;
        this.type = type;
        this.genres = genres;
        startDate = new SeriesStartDate(year, month, day);
    }


    /**
     * Whenever a Series has been read from a file, its fields should be sanitized.
     * Call this method for ensure a proper sanitizing of all Series attributes
     */
    public void sanitize(){

    }
}
