package search;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class LinearSearch {

    public static <T extends Comparable<T>> int search(ArrayList<T> list, T searchTerm) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(searchTerm) == 0) {
                return i;
            }
        }
        return -1;
    }
}
