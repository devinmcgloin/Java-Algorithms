package dataStructures.interfaces;

import dataStructures.Heap;

import java.util.Collection;
import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IHeap<E> extends Seq<E>{

    Heap<E> heapify(Collection<E> c);

    Optional<E> poll();
}
