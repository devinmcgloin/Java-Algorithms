package sort;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class QuickSort {

    private QuickSort() {
    }


    /**
     * avg = O (n log n) worst = O (n^2)
     * <p>
     * todo select pivot
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        sort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void sort(ArrayList<T> list, int start, int finish) {
        int pivotIndex = (start + finish) / 2;
        T pivot = list.get(pivotIndex);


        int s = start;
        int f = finish;

        while (s <= f) {
            while (list.get(s).compareTo(pivot) < 0)
                s++;
            while (list.get(f).compareTo(pivot) > 0)
                f--;
            if (s <= f) {
                swap(list, s, f);
                s++;
                f--;
            }
        }
        if (start < f) {
            sort(list, start, f);
        }
        if (s < finish) {
            sort(list, s, finish);
        }


    }

    private static <T> void swap(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
