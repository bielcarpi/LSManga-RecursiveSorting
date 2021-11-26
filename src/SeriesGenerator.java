import java.util.Random;

public class SeriesGenerator {

    private static final int MAX_POPULARITY = 10000;
    private static final int MAX_SCORE = 100;
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
}
