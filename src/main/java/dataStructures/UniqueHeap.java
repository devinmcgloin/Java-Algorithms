package dataStructures;

import dataStructures.interfaces.IHeap;
import dataStructures.interfaces.Seq;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author devinmcgloin
 * @version 2/15/16.
 */
public class UniqueHeap<E> implements IHeap<E> {

    Heap<E> heap;
    HashSet<E> set;

    public UniqueHeap() {
        heap = new Heap<>();
        set = new HashSet<>();
    }

    @Override
    public Heap<E> heapify(final Collection<E> c) {
        return heap.heapify(c);
    }

    @Override
    public E poll() {
        E first = heap.poll();
        set.remove(first);
        return first;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return heap.toArray();
    }

    @Override
    public E[] toArray(final E[] arr) {
        return heap.toArray(arr);
    }

    @Override
    public boolean add(final E element) {
        if (!set.contains(element)) {
            set.add(element);
            heap.add(element);
            return true;
        } else {
            set.remove(element);

        }

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
