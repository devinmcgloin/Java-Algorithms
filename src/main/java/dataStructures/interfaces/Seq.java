package dataStructures.interfaces;

import java.util.Iterator;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface Seq<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    Object[] toArray();

    E[] toArray(E[] arr);

    boolean add(E element);

    boolean remove(Object element);

    boolean contains(Object element);

    void addAll(Seq<? extends E> elements);

    void removeAll(Seq<? extends E> elements);

    boolean containsAll(Seq<? extends E> elements);

    boolean equals(Object o);

    int hashCode();

}
