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
        }

        logger.debug(list);
        logger.debug(javalist);

    }
}