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
        int middle = 0;
        if (high < low) {
            return -(low + 1);
        }
        middle = (low + high) / 2;

        if (list.get(middle).equals(searchTerm)) {
            return middle;
        } else if (list.get(middle).compareTo(searchTerm) < 0) {
            return recSearch(list, searchTerm, middle + 1, high);
        } else if (list.get(middle).compareTo(searchTerm) > 0) {
            return recSearch(list, searchTerm, low, middle - 1);
        }
        //Shouldn't never reach this
        return -(low + 1);
    }

    private static <T extends Comparable<T>> int recSearch(ArrayList<T> list, T searchTerm, int low, int high) {
        int middle = (low + high) / 2;
        if (high < low) {
            return -(low + 1);
        } else if (list.get(middle).equals(searchTerm)) {
            return middle;
        } else if (list.get(middle).compareTo(searchTerm) < 0) {
            return recSearch(list, searchTerm, middle + 1, high);
        } else if (list.get(middle).compareTo(searchTerm) > 0) {
            return recSearch(list, searchTerm, low, middle - 1);
        }
        //Shouldn't ever reach this
        return -(low + 1);
    }

}
