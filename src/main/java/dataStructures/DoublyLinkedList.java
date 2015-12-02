package dataStructures;

import java.util.NoSuchElementException;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class DoublyLinkedList<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    public DoublyLinkedList() {
    }

    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public E removeLast() {
        E value = last.item;
        if (value == null) {
            throw new NoSuchElementException();
        }
        last = last.prev;
        last.next = null;
        size--;
        return value;
    }

    public E removeFirst() {
        E value = first.item;
        if (value == null || size <= 0) {
            throw new NoSuchElementException();
        }
        first = first.next;
        first.prev = null;
        size--;
        return value;
    }

    public E getLast() {
        Node<E> n = last;
        if (n == null || size <= 0)
            throw new NoSuchElementException();
        return n.item;
    }

    public E getFirst() {
        Node<E> n = first;
        if (n == null)
            throw new NoSuchElementException();
        return n.item;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = first;
        int counter = 0;
        while (current != null) {
            if (counter == index) {
                return current.item;
            }
            current = current.next;
            counter++;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E e) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        Node<E> current = first;
        while (current != null) {
            if (current.next == null)
                output.append(current.item.toString());
            else
                output.append(current.item.toString()).append(", ");
            current = current.next;
        }
        output.append("]");
        return output.toString();
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
