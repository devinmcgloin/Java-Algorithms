package encryption;

/**
 * @author devinmcgloin
 * @version 12/7/15.
 */
public interface SymmetricCipher {

    String encode(String message);

    String decode(String message);

}
