package sort;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class QuickSort {


    /**
     * avg = O (n log n) worst = O (n^2)
     * <p>
     * todo select pivot
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list, int first, int last) {
        int pivotIndex = (first + last) / 2;
        T tmp = list.get(pivotIndex);
        list.set(pivotIndex, list.get(last));
        list.set(last, tmp);
        
    }
}
