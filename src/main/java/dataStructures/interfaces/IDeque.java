package dataStructures.interfaces;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IDeque<E> extends Seq<E> {
    /**
     * remove first.
     * @return
     */
    E poll();

    /**
     * add to end.
     * @param item
     * @return
     */
    boolean offer(E item);

    E first();

    E last();
}
