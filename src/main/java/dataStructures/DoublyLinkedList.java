package dataStructures;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class DoublyLinkedList<E> {
    Node<E> first = null;
    Node<E> last = null;
    int size = 0;

    public DoublyLinkedList(){}

    class Node<E>{
        E value = null;
        Node<E> next = null;
        Node<E> prev = null;

        Node(E value){
            this.value = value;
        }
    }

    public void addLast(E value){
        Node<E> newLast = new Node<E>(value);
        newLast.prev = last;
        last = newLast;
        size++;
    }

    public void addFirst(E value){
        Node<E> newFirst = new Node<E>(value);
        newFirst.next = first;
        first = newFirst;
        size++;
    }
    public E removeLast(){
        E value = last.value;
        last = last.prev;
        size--;
        return value;
    }
    public E removeFirst(){
        E value = first.value;
        first = first.prev;
        size--;
        return value;
    }

    public boolean contains(Object value){

    }

    public Collection<E> toCollection(){

    }

    public int size(){
        return size;
    }

    public int recSize( Node<E> node){
        if(node.next != null){
            return 1 + recSize(node.next);
        }else return 1;
    }

    public E[] toArray(){
        Object[] array = new Object[size];

    }
}
