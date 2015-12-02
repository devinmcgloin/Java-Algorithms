package dataStructures;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 12/1/15.
 */
public class BSTreeTest {
    Random r = new Random();
    int iterations = 5000;

    @Test
    public void generalTest() throws Exception {
        java.util.TreeSet<Integer> javalist = new java.util.TreeSet<Integer>();
        BSTree<Integer> list = new BSTree<>();
        for (int i = 0; i < iterations; i++) {
            Integer item = r.nextInt();
            list.insert(item);
            javalist.add(item);
        }

        for (int i = 0; i < iterations; i++) {
            int choice = r.nextInt(4);

            switch (choice) {
                case 0:
                    Integer searchItem = r.nextInt();
                    list.remove(searchItem);
                    javalist.remove(searchItem);

                    assertThat("Checking Remove", list.size(), is(javalist.size()));
                case 1:
                    assertThat("Checking size", list.size(), is(javalist.size()));
                    break;
                case 2:
                    searchItem = r.nextInt();
                    assertThat(String.format("Searching for: %d", searchItem), list.contains(searchItem), is(javalist.contains(searchItem)));
                    break;
                case 3:
                    assertThat("Checking if empty", list.isEmpty(), is(javalist.isEmpty()));
                    break;
                default:
                    searchItem = r.nextInt();
                    assertThat(String.format("Searching for: %d", searchItem), list.contains(searchItem), is(javalist.contains(searchItem)));
                    break;
            }

        }

        if (!list.isEmpty() && !javalist.isEmpty()) {
            list.clear();
            javalist.clear();
        }

        assertThat(list.size(), is(javalist.size()));
        assertThat(list.size(), is(0));
        assertThat(javalist.size(), is(0));
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }
}