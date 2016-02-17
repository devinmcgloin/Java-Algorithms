package dataStructures;

import dataStructures.interfaces.IList;
import dataStructures.interfaces.IMap;

/**
 * todo not implemeneted
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class HashMap<K,V> implements IMap<K,V> {
    @Override
    public void put(final K key, final V value) {

    }

    @Override
    public V get(final K key) {
        return null;
    }

    @Override
    public IList<K> getKeys() {
        return null;
    }

    @Override
    public IList<V> getValues() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean remove(final K key) {
        return false;
    }

    @Override
    public boolean containsKey(final K key) {
        return false;
    }

    @Override
    public boolean containsValue(final V value) {
        return false;
    }
}
