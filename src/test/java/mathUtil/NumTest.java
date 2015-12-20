package mathUtil;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Random;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class NumTest {
    static Logger logger = Logger.getLogger(NumTest.class);
    Random r = new Random();
    int iterations = 20;

    @Test
    public void testGcd() throws Exception {
        for(int i = 0; i < iterations; i++) {
            long u = r.nextLong();
            long v =  r.nextLong();
//            assertThat(String.format("u: %d\tv: %d", u, v), Num.gcd(u, v), is(ArithmeticUtils.gcd(u,v)));
//            logger.debug(String.format("GCD u: %d\tv: %d = %d", u, v, ArithmeticUtils.gcd(u,v)));
        }
    }

    @Test
    public void testIsEven() throws Exception {

    }
}