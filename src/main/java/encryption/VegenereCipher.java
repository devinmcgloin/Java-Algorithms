package encryption;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class VegenereCipher {
    static Logger logger = Logger.getLogger(CaesarCipher.class);

    public static String encode(String s, String keyword){
        keyword = match(s, keyword);
        logger.debug(keyword);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            int num = (int) s.charAt(i);
            num += (int) keyword.charAt(i);
            buffer.append((char)num);
        }
        return buffer.toString();
    }

    public static String decode(String s, String keyword){
        keyword = match(s, keyword);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            int num = (int) s.charAt(i);
            num -= (int) keyword.charAt(i);
            buffer.append((char)num);
        }
        return buffer.toString();
    }

    public static void main(String[] args){
        String s = "ATTACKATDAWN";
        String inCoded = encode(s, "LEMON");
        logger.debug(inCoded);
        ArrayList<Integer> codePoints = new ArrayList<>();
        for(char c : inCoded.toCharArray()){
            codePoints.add((int)c);
        }
        logger.debug(codePoints);
        logger.debug(decode(inCoded, "LEMON"));
    }

    private static String match(String s, String keyword){
        StringBuffer buffer = new StringBuffer(keyword);
        do{
            int keywordLength = buffer.length();
            int sLength = s.length();
            int difference = sLength - keywordLength;

            if(difference > sLength) {
                buffer.append(keyword);
            }else{
                for(char c : keyword.toCharArray()){
                    buffer.append(c);
                    difference--;
                    if(difference == 0){
                        break;
                    }
                }
            }
        }while(buffer.length() < s.length());
        return buffer.toString();
    }
}
