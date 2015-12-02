package dataStructures;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author devinmcgloin
 * @version 10/28/15.
 */
public class DoublyLinkedListTest {
    static Logger logger = Logger.getLogger(DoublyLinkedListTest.class);
    int iterations = 10;
    Random r = new Random();

    @Test
    public void test() throws Exception {
        java.util.LinkedList<Integer> javalist = new java.util.LinkedList<Integer>();
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 0; i < iterations; i++) {
            Integer item = r.nextInt(10);
            list.addFirst(item);
            javalist.addFirst(item);
        }

        logger.debug(list);
        logger.debug(javalist);

        for (int i = 0; i < iterations; i++) {
            int choice = r.nextInt(4);
            switch (choice) {
                case 0:
                    assertThat("Remove First", list.removeFirst(), is(javalist.removeFirst()));
                    break;
                case 1:
                    assertThat("Remove Last", list.removeLast(), is(javalist.removeLast()));
                    break;
                case 2:
                    assertThat("Size Check", list.size(), is(javalist.size()));
                    Integer searchItem = r.nextInt(list.size());
                    assertThat("Get Check", list.get(searchItem), is(javalist.get(searchItem)));
                    break;
                case 3:
                    assertThat("Empty Check", list.isEmpty(), is(javalist.isEmpty()));
                    break;
                default:
                    searchItem = r.nextInt();
                    assertThat("Contains Check", list.contains(searchItem), is(javalist.contains(searchItem)));
                    break;
            }
        }

        while (!list.isEmpty() && !javalist.isEmpty()) {
            logger.debug(list);
            logger.debug(javalist);
            assertThat(list.removeFirst(), is(javalist.removeFirst()));
        }

        assertThat(list.size(), is(javalist.size()));
        assertThat(list.size(), is(0));
        assertThat(javalist.size(), is(0));
    }
}