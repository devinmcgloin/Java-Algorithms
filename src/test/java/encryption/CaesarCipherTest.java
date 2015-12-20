package encryption;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class CaesarCipherTest {
    Random r = new Random();
    int iterations = 5000;

    @Test
    public void test() throws Exception {
        for(int i = 0; i < iterations; i++) {
            int offset = r.nextInt(100);
            String s = getRandomString(r.nextInt(1000));
            CaesarCipher cc = new CaesarCipher(offset);
            assertThat(s, cc.decode(cc.encode(s)), is(s));
        }
    }

    private String getRandomString(int length){
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() <= length) {
            buffer.append((char) r.nextInt(500));
        }
        return buffer.toString();
    }
}