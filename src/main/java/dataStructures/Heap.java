package dataStructures;

import dataStructures.interfaces.IHeap;
import dataStructures.interfaces.Seq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class Heap<E> implements IHeap<E>{

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

    @Override
    public Heap<E> heapify(final Collection<E> c) {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public E[] toArray(final E[] arr) {
        return arr;
    }

    @Override
    public boolean add(final E element) {
        return false;
    }

    @Override
    public boolean remove(final Object element) {
        return false;
    }

    @Override
    public boolean contains(final Object element) {
        return false;
    }

    @Override
    public void addAll(final Seq<? extends E> elements) {

    }

    @Override
    public void removeAll(final Seq<? extends E> elements) {

    }

    @Override
    public boolean containsAll(final Seq<? extends E> elements) {
        return false;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public enum TYPE {
        min, max
    }
}
