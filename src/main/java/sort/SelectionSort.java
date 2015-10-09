package sort;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class SelectionSort {

    /**
     * worst = O(n^2)
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int arrayIndex = i;
            T currentMin = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    arrayIndex = j;
                }
            }

            if (arrayIndex != i) {
                list.set(arrayIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
}
