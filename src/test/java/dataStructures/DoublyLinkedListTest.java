package dataStructures;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author devinmcgloin
 * @version 10/28/15.
 */
public class DoublyLinkedListTest {

    @Test
    public void testAddLast() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        assertThat(list.getFirst(), is(1));
    }

    @Test
    public void testAddFirst() throws Exception {

    }

    @Test
    public void testRemoveLast() throws Exception {

    }

    @Test
    public void testRemoveFirst() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testToCollection() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testSize1() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {

    }
}