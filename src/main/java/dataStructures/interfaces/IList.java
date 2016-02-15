package dataStructures.interfaces;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IList<E> extends Seq<E> {

    E get(int index);

    E remove(int index);

    int indexOf(E element);
}
