package dataStructures;

import java.util.EmptyStackException;

/**
 * Tested and matched with java implementation
 * implement common java spec
 * @author devinmcgloin
 * @version 10/28/15.
 */
public class LinkedList<E> {
    Node<E> head = null;
    int size = 0;

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
        if(node == null || size == 0)
            return -1;
        else if(node.element.equals(element)){
            return 0;
        }else{
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

        Node(E value){
            this.element = value;
        }
    }
}
