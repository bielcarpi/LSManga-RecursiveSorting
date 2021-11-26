import java.util.Random;

public class SeriesGenerator {

    private static final int MAX_POPULARITY = 10000;
    private static final int MAX_SCORE = 100;
    private static final String[] POSSIBLE_GENRES = {"Action", "Adventure", "Comedy", "Drama", "Sci-Fi",
                                                     "Mystery", "Supernatural", "Romance", "Slice of Life",
                                                     "Sports", "Horror", "Psychological", "Thriller", "Fantasy"};
    private static final int MAX_POSSIBLE_GENRES = 3;
    private static final int YEARS_FROM_1970 = 51;

    private static final Random r = new Random();

    /**
     * This method generates a non-real amount of people that have seen a Series, its averageScore and
     * how many people have that Series as favourite.
     * <p>It returns an integer array with 3 positions:
     * <ul>
     *     <li>0 -> Popularity</li>
     *     <li>1 -> averageScore</li>
     *     <li>0 -> favourites</li>
     * </ul>
     * @return integer array with length 3 (see description for more info)
     */
    public static int[] getAudience(){
        return new int[]{r.nextInt(MAX_POPULARITY + 1), r.nextInt(MAX_SCORE + 1), r.nextInt(popularity + 1)};
    }

    /**
     * This method generates a non-real type for a Series.
     * <p>Possible values can be either MANGA or ANIME
     * @return The Type of non-real Series
     */
    public static String getType(){
        return r.nextBoolean()? "MANGA": "ANIME";
    }

    /**
     * This method generates a random Genres array for a Series.
     * @return Random Genres array for a Series
     */
    public static String[] getGenres(){
        int numGenres = r.nextInt(MAX_POSSIBLE_GENRES + 1);
        String[] genres = new String[numGenres];

        for(int i = 0; i < genres.length; i++){
            int randomGenre = r.nextInt(POSSIBLE_GENRES.length - 1);
            genres[i] = POSSIBLE_GENRES[randomGenre];
            //We don't check for repeated genres. It could happen. It's for performance reasons.
        }

        return genres;
    }

    /**
     * This method generates a random Premiere Date for a Series.
     * @return Array of 3 int representing year (0), month (1) and day (2)
     */
    public static int[] getPremiereDate(){
        return new int[]{1970 + r.nextInt(YEARS_FROM_1970 + 1), 1 + r.nextInt(12), 1 + r.nextInt(28)};
    }
}
