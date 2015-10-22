package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 10/9/15.
 */
public class BinarySearchTest {

    @org.junit.Test
    public void testRecSearch() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        for (int times = 0; times < 500; times++) {
            Integer search = r.nextInt(1000);
            list.add(search);
            for (int i = 0; i < 500; i++) {
                list.add(r.nextInt(1000));
            }
            Collections.sort(list);
            int result = BinarySearch.recSearch(list, search);

            assertThat(result, is(Collections.binarySearch(list, search)));
            list.clear();
        }

        Integer search = r.nextInt(1000);
        for (int i = 0; i < 1000; i++) {
            list.add(r.nextInt(1000));
        }
        Collections.sort(list);
        int result = BinarySearch.recSearch(list, search);

        assertThat(result, is(Collections.binarySearch(list, search)));
        list.clear();

        search = r.nextInt(1000);
        for (int i = 0; i < 0; i++) {
            list.add(r.nextInt(1000));
        }
        Collections.sort(list);
        result = BinarySearch.recSearch(list, search);

        assertThat(result, is(Collections.binarySearch(list, search)));
        list.clear();
    }

    @org.junit.Test
    public void testSearch() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        for (int times = 0; times < 500; times++) {
            Integer search = r.nextInt(1000);
            list.add(search);
            for (int i = 0; i < 500; i++) {
                list.add(r.nextInt(1000));
            }
            Collections.sort(list);
            int result = BinarySearch.search(list, search);

            assertThat(result, is(Collections.binarySearch(list, search)));
            list.clear();
        }

        Integer search = r.nextInt(1000);
        for (int i = 0; i < 1000; i++) {
            list.add(r.nextInt(1000));
        }
        Collections.sort(list);
        int result = BinarySearch.search(list, search);

        assertThat(result, is(Collections.binarySearch(list, search)));
        list.clear();

        search = r.nextInt(1000);
        for (int i = 0; i < 0; i++) {
            list.add(r.nextInt(1000));
        }
        Collections.sort(list);
        result = BinarySearch.search(list, search);

        assertThat(result, is(Collections.binarySearch(list, search)));
        list.clear();
    }
}