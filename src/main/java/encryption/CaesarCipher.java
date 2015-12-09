package encryption;

import org.apache.log4j.Logger;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class CaesarCipher implements SymmetricCipher {

    static Logger logger = Logger.getLogger(CaesarCipher.class);
    int offset;

    public CaesarCipher(final int offset) {
        this.offset = offset;
    }

    public static void main(String[] args) {
        String s = "ATTACK AT DAWN";
        int key = 12;
        CaesarCipher cc = new CaesarCipher(key);

        String inCoded = cc.encode(s);
        String decoded = cc.decode(inCoded);
        logger.debug(String.format("Initial Message: %s\n\t\tKeyword: %s\n\n\t\tEncoded: %s\n\t\tDecoded: %s ", s, key, inCoded, decoded));

    }

    public String encode(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            int num = (int) c;
            num += offset;
            buffer.append((char) num);
        }
        return buffer.toString();
    }

    public void setOffset(final int offset) {
        this.offset = offset;
    }

    public String decode(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            int num = (int) c;
            num -= offset;
            buffer.append((char) num);
        }
        return buffer.toString();
    }
}
