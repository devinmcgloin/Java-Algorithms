package encryption;

import org.apache.log4j.Logger;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class CaesarCipher {

    static Logger logger = Logger.getLogger(CaesarCipher.class);

    public static String encode(String s, int offset){
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()){
            int num = (int) c;
            num += offset;
            buffer.append((char)num);
        }
        return buffer.toString();
    }

    public static String decode(String s, int offset){
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()){
            int num = (int) c;
            num -= offset;
            buffer.append((char)num);
        }
        return buffer.toString();
    }

    public static void main(String[] args){
        String s = "there is a large army over the hills to the west. 10000 strong";
        String inCoded = encode(s, 500);
        logger.debug(inCoded);
        logger.debug(decode(inCoded, 500));
    }
}
