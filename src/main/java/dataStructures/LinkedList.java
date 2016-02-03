package dataStructures;

import dataStructures.interfaces.IDeque;
import dataStructures.interfaces.IList;
import dataStructures.interfaces.Seq;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Tested and matched with java implementation implement common java spec
 * todo this needs to turn into a double linked list.
 * @author devinmcgloin
 * @version 10/28/15.
 */
public class LinkedList<E> implements IList<E>,IDeque<E> {
    Node<E> head = null;
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
    public E get(final int index) {
        return null;
    }

    @Override
    public E remove(final int index) {
        return null;
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

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return head.element;
    }

    public E push(E element) {
        if (head == null) {
            head = new Node<>(element);
            size++;
            return element;
        } else {
            Node<E> newHead = new Node<>(element);
            newHead.next = head;
            head = newHead;
            size++;
            return element;
        }
    }

    public int search(E element) {
        if (isEmpty() || element == null)
            return -1;
        int pos = 1;
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return pos;
            }
            pos++;
            current = current.next;
        }
        return -1;
    }

    private int search(Node<E> node, E element) {
        if (node == null || size == 0)
            return -1;
        else if (node.element.equals(element)) {
            return 0;
        } else {
            return 1 + search(node.next, element);
        }
    }


    @Override
    public String toString() {
        return "size = " + size;
    }

    private class Node<E> {
        E element = null;
        Node<E> next = null;

        Node(E value) {
            this.element = value;
        }
    }
}
