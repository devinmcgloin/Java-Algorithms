package dataStructures.interfaces;

import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IMap <K,V> {

    void put(K key, V value);

    Optional<V> get(K key);

    IList<K> getKeys();

    IList<V> getValues();

    void clear();

    int size();

    boolean remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

}
