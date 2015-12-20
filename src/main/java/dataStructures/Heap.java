package dataStructures;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class Heap<E> {

    ArrayList<E> list;

    public Heap() {
        list = new ArrayList<E>();
        list.add(null);
    }

    public boolean insert(E element) {
        if (list.get(0) == null) {
            list.set(0, element);
        }
        return insert(0, element);
    }

    private boolean insert(int k, E element) {
        if (list.get(getLeft(k)) == null) {
            list.set(getLeft(k), element);
            return true;
        } else {
            return (insert(getLeft(k), element) || insert(getRight(k), element));
        }

    }

    private int getLeft(int k) {
        return 2 * k + 1;
    }

    private int getRight(int k) {
        return 2 * k + 2;
    }

    private int getParent(int k) {
        return (k - 1) / 2;
    }

    public enum TYPE {
        min, max
    }
}
