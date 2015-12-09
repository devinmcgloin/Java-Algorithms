package encryption;

import org.apache.log4j.Logger;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class VegenereCipher implements SymmetricCipher {
    static Logger logger = Logger.getLogger(CaesarCipher.class);
    String keyword;

    public VegenereCipher(final String keyword) {

        this.keyword = keyword;
    }

    public static void main(String[] args) {
        String s = "ATTACK AT DAWN";
        String key = "7sad8and23";
        VegenereCipher vc = new VegenereCipher(key);

        String inCoded = vc.encode(s);
        String decoded = vc.decode(inCoded);
        logger.debug(String.format("Initial Message: %s\n\t\tKeyword: %s\n\n\t\tEncoded: %s\n\t\tDecoded: %s ", s, key, inCoded, decoded));
    }

    private static String repeatToMatch(int sLength, String keyword) {
        StringBuffer buffer = new StringBuffer(keyword);
        do {
            int keywordLength = buffer.length();
            int difference = sLength - keywordLength;

            if (difference > sLength) {
                buffer.append(keyword);
            } else {
                for (char c : keyword.toCharArray()) {
                    buffer.append(c);
                    difference--;
                    if (difference == 0) {
                        break;
                    }
                }
            }
        } while (buffer.length() < sLength);
        return buffer.toString();
    }

    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }

    public String encode(String s) {
        keyword = repeatToMatch(s.length(), keyword);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i);
            num += (int) keyword.charAt(i);
            buffer.append((char) num);
        }
        return buffer.toString();
    }

    public String decode(String s) {
        keyword = repeatToMatch(s.length(), keyword);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i);
            num -= (int) keyword.charAt(i);
            buffer.append((char) num);
        }
        return buffer.toString();
    }
}
