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
        Random r = new Random();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                list.add(r.nextInt(10));
            }
            System.out.println(list);
            InsertionSort.sort(list);
            System.out.println(list);
            assertThat("Trial: " + i, Ordering.natural().isOrdered(list), is(true));
        }
    }

    @Test
    public void testRecursiveSort() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                list.add(r.nextInt(10));
            }
            System.out.println(list);
            InsertionSort.recursiveSort(list);
            System.out.println(list);
            assertThat("Trial: " + i, Ordering.natural().isOrdered(list), is(true));
        }
    }


}