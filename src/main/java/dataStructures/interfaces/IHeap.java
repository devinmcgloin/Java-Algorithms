package dataStructures.interfaces;

import dataStructures.Heap;

import java.util.Collection;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IHeap<E> extends Seq<E>{

    Heap<E> heapify(Collection<E> c);

    E poll();
}
