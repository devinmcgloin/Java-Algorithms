package dataStructures.interfaces;

import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IDeque<E> extends Seq<E> {

    /**
     * add to end.
     * @param item
     * @return
     */
    boolean offer(E item);

    Optional<E> first();

    Optional<E> last();

    void addFirst(E element);

    void addLast(E element);

    Optional<E> peek();

    Optional<E> pop();

    boolean push(E element);
}
