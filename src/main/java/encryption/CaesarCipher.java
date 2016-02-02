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
