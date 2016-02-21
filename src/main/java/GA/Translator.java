package GA;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author devinmcgloin
 * @version 12/20/15.
 */
abstract class Translator<E> {
    static Random r = new Random();

    private static void genBinSeq(String s, int len, ArrayList<String> list) {
        if (s.length() == len) {
            list.add(s);
        } else {
            genBinSeq(s + "0", len, list);
            genBinSeq(s + "1", len, list);
        }
    }

    static ArrayList<String> genBinSeq(int len) {
        ArrayList<String> list = new ArrayList<>();
        genBinSeq("", len, list);
        return list;
    }

    static String genRandBitStr(int length) {
        StringBuffer buffer = new StringBuffer();
        int k = 0;
        while (k < length) {
            k++;
            if (r.nextDouble() <= .5)
                buffer.append("0");
            else
                buffer.append("1");
        }
        return buffer.toString();
    }



    abstract E decode(String s);

    abstract String encode(E item);

    abstract ArrayList<String> genRandOffspring();


}
