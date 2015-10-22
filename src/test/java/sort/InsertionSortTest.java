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
public class InsertionSortTest {

    @Test
    public void testSort() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random(0);

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 1000; j++) {
                list.add(r.nextInt());
            }

            InsertionSort.sort(list);

            assertThat("Trial: " + i, Ordering.natural().isOrdered(list), is(true));
            list.clear();
        }
    }

    @Test
    public void testRecursiveSort() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random(0);

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 1000; j++) {
                list.add(r.nextInt());
            }
            InsertionSort.recursiveSort(list);
            assertThat("Trial: " + i, Ordering.natural().isOrdered(list), is(true));
            list.clear();
        }
    }


}