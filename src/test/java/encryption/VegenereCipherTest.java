package encryption;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class VegenereCipherTest {
    Random r = new Random();
    int iterations = 5000;

    @Test
    public void test() throws Exception {
        for (int i = 0; i < iterations; i++) {
            String keyword = getRandomString(r.nextInt(100));
            String s = getRandomString(r.nextInt(1000));
            VegenereCipher vc = new VegenereCipher(keyword);
            assertThat(s, vc.decode(vc.encode(s)), is(s));
        }
    }

    private String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() <= length) {
            buffer.append((char) r.nextInt(500));
        }
        return buffer.toString();
    }
}