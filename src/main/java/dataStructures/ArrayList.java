package dataStructures;


import dataStructures.interfaces.IList;
import dataStructures.interfaces.Seq;

import java.util.Iterator;
import java.util.Optional;

/**
 * todo need to implmenet
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class ArrayList<E> implements IList<E> {
    private static int DEFAULT_CAPACITY = 12;
    int size;
    private Object[] elementData;

    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Optional<E> get(final int index) {
        return Optional.of((E) elementData[index]);
    }

    @Override
    public Optional<E> remove(final int index) {
        return null;
    }

    @Override
    public int indexOf(final E element) {
        for(int i = 0; i < size; i++){
            E ith = (E) elementData[i];
            if(ith.equals(element))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return elementData.clone();
    }

    @Override
    public E[] toArray(E[] arr) {
        if(arr.length >= size){
            System.arraycopy(elementData, 0, arr, 0, size);
        }
        arr = null;
        return arr;
    }

    @Override
    public boolean add(final E element) {
        ensureCapacity(size << 2);
        elementData[size + 1] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(final Object element) {
        return false;
    }

    @Override
    public boolean contains(final Object element) {
        for(int i = 0; i < size; i++){
            if(elementData[i].equals(element)){
                return true;
            }
        }
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

    private void ensureCapacity(int capacity){}

    private void grow(int capacity){}
}
