import java.util.Comparator;

/**
 * {@code SortUtility} is a class designed to help with sorting arrays of {@code Objects}.
 * <p>As we want to order an Object T, we'll use {@code Generics}.
 * <br>
 * <p>The class will provide methods for sorting an array with different algorithms, such as merge sort, quick sort or bucket sort
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">Generics</a>
 * @author bielcarpi
 * @version 1.0
 */
public class SortUtility<T> {

    /**
     * Orders (using merge sort) an array of {@code T Objects} given a {@link Comparator<T>} for that same {@code object}
     * <p>The array passed is the one that will be modified, this method is void.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge Sort</a>
     * @param array The array that will be ordered
     * @param comparator The criteria that will order the array
     */
    public void mergeSort(T[] array, Comparator<T> comparator){
    }
}
