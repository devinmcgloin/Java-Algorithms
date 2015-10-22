package sort;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class MergeSortTest {

    @Test
    public void testSort() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 1000; j++) {
                list.add(r.nextInt());
            }
            MergeSort.sort(list);
            assertThat("Trial: " + i, Ordering.natural().isOrdered(list), is(true));
            list.clear();
        }
    }
}