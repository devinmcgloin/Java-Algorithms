package dataStructures;

import java.util.EmptyStackException;

/**
 * implement more features
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class Stack<E> {
    Node<E> head = null;

    public Stack() {
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

        final E searchItem = (E) element;
        int pos = 1;
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(searchItem)) {
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
    class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            next = null;
        }
    }
}
