package dataStructures;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class DoublyLinkedList<E> {
    Node<E> first = null;
    Node<E> last = null;
    int size = 0;

    public DoublyLinkedList() {
    }

    class Node<E> {
        E value = null;
        Node<E> next = null;
        Node<E> prev = null;

        Node(E value) {
            this.value = value;
        }
    }

    public void addLast(E value) {
        Node<E> newLast = new Node<E>(value);
        if (first == null) {
            first = newLast;
            last = newLast;
            last.prev = first;
            first.next = last;
        } else {
            newLast.prev = last;
            last = newLast;
        }
        size++;
    }

    public void addFirst(E value) {
        Node<E> newFirst = new Node<E>(value);
        if (first == null) {
            first = newFirst;
            last = newFirst;
            last.prev = first;
            first.next = last;
        } else {
            newFirst.next = first;
            first = newFirst;
        }
        size++;
    }

    public E getLast() {
        E value = last.value;
        last = last.prev;
        last.next = null;
        size--;
        return value;
    }

    public E getFirst() {
        E value = first.value;
        first = first.next;
        first.prev = null;
        size--;
        return value;
    }

    public E get(int index) {
        return null;
    }

    public int size() {
        return size;
    }

}
