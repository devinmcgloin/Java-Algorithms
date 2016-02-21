package dataStructures.interfaces;

import java.util.List;
import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public interface IMap <K,V> {

    void put(K key, V value);

    Optional<V> get(K key);

    List<K> getKeys();

    List<V> getValues();

    void clear();

    int size();

    boolean remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

}
