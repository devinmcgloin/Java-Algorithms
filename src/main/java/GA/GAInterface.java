package GA;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 12/18/15.
 */
public interface GAInterface<E> {

    static void genBinSeq(String s, int len, ArrayList<String> list) {
        if (s.length() == len) {
            list.add(s);
        } else {
            genBinSeq(s + "0", len, list);
            genBinSeq(s + "1", len, list);
        }
    }

    String encode();

    E decode(String e);

    double fitness();

}
