package dataStructures;

import dataStructures.interfaces.IStack;
import dataStructures.interfaces.Seq;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * implement more features, dont let null values in.
 *
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class Stack<E> implements IStack<E> {

    Node<E> head = null;

    public Stack() {
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

    /**
     * empty returns true if the stack is empty, and false if it is not.
     *
     * @return true if the stack is empty
     */
    public boolean empty() {
        return head == null;
    }

    /**
     * removes the head of the stack, and returns it
     *
     * @return the top element in the stack
     */
    public E pop() {
        if (empty())
            throw new EmptyStackException();
        E element = head.element;
        head = head.next;
        return element;
    }

    /**
     * returns the head element of the stack without returning it
     *
     * @return the top element of the stack
     */
    public E peek() {
        if (empty())
            throw new EmptyStackException();
        return head.element;
    }

    /**
     * Adds the specified element to the stack
     *
     * @param element element to be added to the stack
     *
     * @return the element passed into the function
     */
    public E push(E element) {
        if (head == null) {
            head = new Node<>(element);
            return element;
        } else {
            Node<E> newHead = new Node<>(element);
            newHead.next = head;
            head = newHead;
            return element;
        }
    }

    /**
     * Returns the position of the element if present in the stack, else returns -1. Index is 1 based.
     *
     * @param element element to search for
     *
     * @return the index of the element in the stack, -1 if not present
     */
    public int search(Object element) {

        if (empty() || element == null || !(element.getClass().equals(head.element.getClass())))
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

    /**
     * Returns the size of the stack
     *
     * @return size of the stack
     */
    public int size() {
        Node<E> current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }


    /**
     * To string returns the size of the array
     *
     * @return size of the array
     */
    @Override
    public String toString() {
        return "size = " + size();
    }

    /**
     * simple node class that serves as cons and car cells.
     *
     * @param <T>
     */
    private class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            next = null;
        }
    }
}
