package sort;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class MergeSort {

    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        int half = list.size() / 2;
        sort(list, 0, half, half + 1, list.size() - 1);    // split to four here
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> list, int aStart, int aEnd, int bStart, int bEnd) {
        if (aEnd - aStart == 2) {

        } else if (bEnd - bStart == 2) {

        } else {
            int aHalf = (aStart + aEnd) / 2;
            int bHalf = (bStart + bEnd) / 2;
            sort(list, aStart, aHalf, aHalf + 1, aEnd);
            sort(list, bStart, bHalf, bHalf + 1, bEnd);
            merge(list, aStart, aEnd, bStart, bEnd);
        }
    }

    public static <T extends Comparable<T>> void merge(ArrayList<T> list, int aStart, int aEnd, int bStart, int bEnd) {
        while (aStart < aEnd && bStart < bEnd) {
            T a = list.get(aStart);
            T b = list.get(bStart);
            if (a.compareTo(b) > 0) { // B is less than A
                list.remove(b);
                list.add(aStart, b);
                aEnd++;
                bStart++;
            } else {
                aStart++;
            }
        }

    }
}
