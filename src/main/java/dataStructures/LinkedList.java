package dataStructures;

import dataStructures.interfaces.IDeque;
import dataStructures.interfaces.IList;
import dataStructures.interfaces.Seq;

import java.util.Iterator;

/**
 * Tested and matched with java implementation implement common java spec
 * todo this needs to turn into a double linked list.
 * @author devinmcgloin
 * @version 10/28/15.
 */
public class LinkedList<E> implements IList<E>,IDeque<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;

    /**
     * remove first.
     *
     * @return
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * add to end.
     *
     * @param item
     * @return
     */
    @Override
    public boolean offer(final E item) {
        return false;
    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public void addFirst(final E element) {

    }

    @Override
    public void addLast(final E element) {

    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean push(final E element) {
        return false;
    }

    @Override
    public E get(final int index) {
        return null;
    }

    @Override
    public E remove(final int index) {
        return null;
    }

    @Override
    public int indexOf(final E element) {
        return 0;
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

    private class Node<E> {
        E element = null;
        Node<E> next = null;
        Node<E> prev = null;

        Node(E value) {
            this.element = value;
        }
    }
}
