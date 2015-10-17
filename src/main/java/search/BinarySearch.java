package search;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/7/15.
 */
public class BinarySearch {
    public static <T extends Comparable<T>> int recSearch(ArrayList<T> list, T searchTerm) {
        int low = 0;
        int high = list.size() - 1;
        int middle;
        if (high < low) {
            return -(low + 1);
        }

        middle = (low + high) >> 1; //bit shift divide by two.
        T temp = list.get(middle);
        int comp = temp.compareTo(searchTerm);

        if (comp < 0) {
            return recSearch(list, searchTerm, middle + 1, high);
        } else if (comp > 0) {
            return recSearch(list, searchTerm, low, middle - 1);
        } else return middle;
    }

    private static <T extends Comparable<T>> int recSearch(ArrayList<T> list, T searchTerm, int low, int high) {
        int middle = (low + high) >> 1; //bit shift divide by two.
        T temp = list.get(middle);
        int comp = temp.compareTo(searchTerm);

        if (high < low) {
            return -(low + 1);
        }
        if (comp < 0) {
            return recSearch(list, searchTerm, middle + 1, high);
        } else if (comp > 0) {
            return recSearch(list, searchTerm, low, middle - 1);
        } else return middle;
    }

    public static <T extends Comparable<T>> int search(ArrayList<T> list, T searchTerm) {
        int low = 0;
        int high = list.size() - 1;
        int middle;

        while (high >= low) {
            middle = (low + high) >> 1; //bit shift divide by two.
            T temp = list.get(middle);
            int comp = temp.compareTo(searchTerm);
            if (comp < 0) {
                low = middle + 1;
            } else if (comp > 0) {
                high = middle - 1;
            } else return middle;
        }
        return -(low + 1);
    }

}
