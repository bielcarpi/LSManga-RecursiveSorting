import java.util.Random;

public class SeriesGenerator {

    private static final int MAX_POPULARITY = 10000;
    private static final int MAX_SCORE = 100;
    private static final String[] POSSIBLE_GENRES = {"Action", "Adventure", "Comedy", "Drama", "Sci-Fi",
                                                     "Mystery", "Supernatural", "Romance", "Slice of Life",
                                                     "Sports", "Horror", "Psychological", "Thriller", "Fantasy"};
    private static final int MAX_POSSIBLE_GENRES = 3;
    private static final int YEARS_FROM_1970 = 51;
    private static final String[] WORDS_ROMAJI = {"Initial", "Stage", "Naruto", "One", "Piece", "Sunabozu", "Trinity", "Blood", "Evangelion", "Seiki", "Koukaku", "Rurouni", "Chobits", "Ninpouchou"};
    private static final String[] WORDS_ENGLISH = {"Initial", "Stage", "Naruto", "One", "Piece", "Desert Punk", "Trinity", "Blood", "Evangelion", "Genesis", "Ghost", "Samurai", "Chobits", "Ninja"};
    private static final String[] WORDS_NATIVE = {"頭文字", "STAGE", "ナルト", "ワンピース", "砂ぼ", "うず", "トリニティ", "ブラッド", "リオン", "新世紀", "攻殻", "るろう", "ちょびっツ", "甲賀忍"};
    private static final int MAX_POSSIBLE_WORDS = 4;

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
        int popularity = r.nextInt(MAX_POPULARITY + 1);
        return new int[]{popularity, r.nextInt(MAX_SCORE + 1), r.nextInt(popularity + 1)};
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
        int numGenres = 1 + r.nextInt(MAX_POSSIBLE_GENRES);
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

    /**
     * This method generates random titles for a Series.
     * <p>Each Series has three titles, so the method will return an array with length 3:
     * <ul>
     *     <li>0 -> Romaji Title</li>
     *     <li>1 -> English Title</li>
     *     <li>2 -> Native Title</li>
     * </ul>
     * @return String of length 3 with randomly-generated titles
     */
    public static String[] getTitles(){
        String[] titles = new String[]{"", "", ""};

        int words = 1 + r.nextInt(MAX_POSSIBLE_WORDS);
        int[] wordsIndex = new int[words];


        //Get random words' index
        for(int i = 0; i < words; i++)
            wordsIndex[i] = r.nextInt(WORDS_ROMAJI.length);

        //Generate Titles from words' index
        //Again, Words can be repeated in a title (performance reasons)
        for(int index: wordsIndex){
            titles[0] += (WORDS_ROMAJI[index] + " ");
            titles[1] += (WORDS_ENGLISH[index] + " ");
            titles[2] += (WORDS_NATIVE[index] + " ");
        }

        //Remove last space " " character
        titles[0] = titles[0].substring(0, titles[0].length() - 1);
        titles[1] = titles[1].substring(0, titles[1].length() - 1);
        titles[2] = titles[2].substring(0, titles[2].length() - 1);

        return titles;
    }
}
