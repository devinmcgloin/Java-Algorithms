package core;

import java.util.Collection;

/**
 * @author devinmcgloin
 * @version 2/20/16.
 */
public class StringFactory {

    private StringFactory(){}

    public static void binSeq(Collection<String> col, int len){
        binSeq(col, len, "");
    }

    private static void binSeq(Collection<String> col ,int len, String primer){
        if(primer.length() == len)
            col.add(primer);
        else{
            binSeq(col, len, primer + "0");
            binSeq(col, len, primer + "1");
        }
    }
}
