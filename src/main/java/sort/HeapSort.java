package sort;

import dataStructures.Heap;
import dataStructures.interfaces.IHeap;

import java.util.Collection;
import java.util.Comparator;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class HeapSort {

    private HeapSort(){}

    public static <E extends Comparable<E>> void sort(Collection<E> c){
        IHeap<E> heap = new Heap<E>();
        heap.heapify(c);
        c.clear();
        while(!heap.isEmpty()){
            c.add(heap.poll());
        }
    }
}
