package sort;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class InsertionSort {


    /**
     * Average case = O(n^2)
     * Worst case = O(n^2)
     * Best case = O(n)
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; (j > 0) && list.get(j).compareTo(list.get(j - 1)) < 0; j--) {
                swap(list, j, j - 1);
            }
        }
    }

    private static <T> void swap(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static <T extends Comparable<T>> void recursiveSort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            recursiveSort(list, i);
        }
    }

    private static <T extends Comparable<T>> void recursiveSort(ArrayList<T> list, int i) {
        if (i == list.size())
            return;
        for (int j = i; (j > 0) && list.get(j).compareTo(list.get(j - 1)) < 0; j--) {
            swap(list, j, j - 1);
            recursiveSort(list, i + 1);
        }
    }

}
