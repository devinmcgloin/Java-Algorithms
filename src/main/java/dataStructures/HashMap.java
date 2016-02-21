package dataStructures;

import dataStructures.interfaces.IList;
import dataStructures.interfaces.IMap;
import org.apache.log4j.Logger;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * todo not implemeneted
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class HashMap<K,V> implements IMap<K,V> {

    static Logger logger = Logger.getLogger(HashMap.class);

    ArrayList<LinkedList<Tuple<K, V>>> backing;
    int buckets = 12;
    int size = 0;
    static final double LOAD_FACTOR = .75f;

    public HashMap(){
        backing = new ArrayList<>(buckets);
        logger.debug("Entered Constructor");
        for(LinkedList<Tuple<K, V>> list : backing) {
            logger.debug(list);
            list = new LinkedList<Tuple<K, V>>();
        }
    }

    @Override
    public void put(final K key, final V value) {
        int b = key.hashCode() % buckets;
        backing.get(b).add(new Tuple<K, V>(key, value));
        size++;
        ensureCapacity();
    }

    @Override
    public Optional<V> get(final K key) {
        int b = key.hashCode() % size;
        for(Tuple<K, V> item : backing.get(b)){
            if(item.equals(key))
                return Optional.of(item.getItemB());
        }
        return Optional.empty();
    }

    @Override
    public List<K> getKeys() {
        List<K> keys = new java.util.LinkedList<>();
        for(LinkedList<Tuple<K,V>> list : backing){
            for(Tuple<K,V> item : list)
                keys.add(item.getItemA());
        }
        return keys;
    }

    @Override
    public List<V> getValues() {
        List<V> keys = new java.util.LinkedList<>();
        for(LinkedList<Tuple<K,V>> list : backing){
            for(Tuple<K,V> item : list)
                keys.add(item.getItemB());
        }
        return keys;
    }

    @Override
    public void clear() {
        backing.clear();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(final K key) {
        int b = key.hashCode() % size;
        Iterator<Tuple<K,V>> iter = backing.get(b).iterator();
        while(iter.hasNext()){
            Tuple<K,V> item = iter.next();
            if(item.equals(key)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(final K key) {
        int b = key.hashCode() % size;
        for(Tuple<K, V> item : backing.get(b)){
            if(item.equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(final V value) {
        return false;
    }

    private void ensureCapacity(){
        if(size > LOAD_FACTOR * buckets)
            grow();
    }

    private void grow(){
        int newBucket = 2 * buckets;
        ArrayList<LinkedList<Tuple<K, V>>> newBacking = new ArrayList<>(newBucket);
        for(LinkedList<Tuple<K, V>> list : newBacking)
            list = new LinkedList<Tuple<K, V>>();
        for(LinkedList<Tuple<K, V>> list : backing){
            for(Tuple<K,V> item : list){
                int index = item.itemA.hashCode() % newBucket;
                newBacking.get(index).add(item);
            }
        }
        buckets = newBucket;
        backing = newBacking;
    }

    public static void main(String[] args){
        HashMap<Integer, String> strMap = new HashMap<>();
        strMap.put(12, "cat");

        logger.debug(strMap.get(12));
    }
}
