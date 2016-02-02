package dataStructures.interfaces;

import java.util.Collection;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IList<E> extends Seq<E> {

    E get(int index);

    E remove(int index);

}
