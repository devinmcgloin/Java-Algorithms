package core;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author devinmcgloin
 * @version 2/20/16.
 */
public class Collections {
    static Logger logger = Logger.getLogger(Collections.class);

    private Collections(){}

    public static <E> void distinct(Collection<E> collection){
        Hashtable<Integer, E> map = new Hashtable<>();
        Iterator<E> iter = collection.iterator();
        while(iter.hasNext()){
            E item = iter.next();
            int hash = item.hashCode();
            if(map.containsKey(hash)){
                E other = map.get(hash);
                if(other.equals(item))
                    iter.remove();
            }else{
                map.put(hash, item);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        StringFactory.binSeq(list, 2);
        StringFactory.binSeq(list, 2);
        logger.debug(list.size());
        distinct(list);
        logger.debug(list.size());
        logger.debug(list);
    }
}
