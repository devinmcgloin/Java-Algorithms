package dataStructures;

import dataStructures.interfaces.ISet;
import dataStructures.interfaces.Seq;

import java.util.Iterator;

/**
 * todo not implemented
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class HashSet<E> implements ISet<E> {

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
}
