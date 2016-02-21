package dataStructures.interfaces;

import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IList<E> extends Seq<E> {

    Optional<E> get(int index);

    Optional<E> remove(int index);

    int indexOf(E element);
}
