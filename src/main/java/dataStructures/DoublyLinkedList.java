package dataStructures;

/**
 * implement
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class DoublyLinkedList<E> {

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
