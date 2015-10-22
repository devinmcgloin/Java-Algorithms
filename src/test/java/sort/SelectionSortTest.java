package sort;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 10/17/15.
 */
public class SelectionSortTest {

    @Test
    public void testSort() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 1000; j++) {
                list.add(r.nextInt());
            }

            SelectionSort.sort(list);

            assertThat("Trial: " + i, Ordering.natural().isOrdered(list), is(true));
            list.clear();
        }
    }
}