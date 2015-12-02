package dataStructures;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 11/24/15.
 */
public class LinkedListTest {
    int iterations = 10000;
    Random r = new Random();

    @Test
    public void test() throws Exception {
        java.util.LinkedList<Integer> javalist = new java.util.LinkedList<Integer>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            Integer item = r.nextInt();
            list.push(item);
            javalist.push(item);
        }

        for (int i = 0; i < iterations; i++) {
            int choice = r.nextInt(4);
            try {
                switch (choice) {
                    case 0:
                        assertThat(list.peek(), is(javalist.peek()));
                        break;
                    case 1:
                        assertThat(list.pop(), is(javalist.pop()));
                        break;
                    case 2:
                        Integer searchItem = r.nextInt();
                        assertThat(list.search(searchItem), is(javalist.indexOf(searchItem)));
                        break;
                    case 3:
                        assertThat(list.isEmpty(), is(javalist.isEmpty()));
                        break;
                    default:
                        searchItem = r.nextInt();
                        assertThat(list.search(searchItem), is(javalist.indexOf(searchItem)));
                        break;
                }
            } catch (EmptyStackException e) {
                continue;
            }
        }

        while (!list.isEmpty() && !javalist.isEmpty()) {
            assertThat(list.pop(), is(javalist.pop()));
        }

        assertThat(list.size(), is(javalist.size()));
        assertThat(list.size(), is(0));
        assertThat(javalist.size(), is(0));
    }


}