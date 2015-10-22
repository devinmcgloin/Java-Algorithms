package sort;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        sort(list, 0, list.size());
    }

    private static <T extends Comparable<T>> void sort(ArrayList<T> list, int start, int length) {
        if (length > 2) {
            int aLength = length / 2;
            int bLength = length - aLength;
            sort(list, start, aLength);
            sort(list, start + aLength, bLength);
            merge(list, start, aLength, start + aLength, bLength);
        } else if (length == 2) {
            T item = list.get(start);
            if (item.compareTo(list.get(start + 1)) > 0) {
                list.set(start, list.get(start + 1));
                list.set(start + 1, item);
            }
        }
    }

    private static <T extends Comparable<T>> void merge(ArrayList<T> list, int aStart, int aLength, int bStart, int bLength) {
        int i = aStart;
        int j = bStart;

        int aSize = aLength + aStart;
        int bSize = bLength + bStart;

        while (i < aSize && j < bSize) {
            T a = list.get(i);
            T b = list.get(j);
            if (a.compareTo(b) > 0) { // B is less than A
                list.remove(j);
                list.add(i, b);
                i++;
                j++;
                aSize++;
            } else {
                i++;
            }
        }
    }


}
