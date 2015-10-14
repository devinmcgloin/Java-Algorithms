package dataStructures;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class QueueTest {
    Queue<String> queue = new Queue<String>();

    @Test
    public void testOffer() throws Exception {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        assertThat(queue.dequeue(), is(Optional.of("a")));
        assertThat(queue.dequeue(), is(Optional.of("b")));
        assertThat(queue.dequeue(), is(Optional.of("c")));

        queue.enqueue("e");
        queue.enqueue("f");

        assertThat(queue.dequeue(), is(Optional.of("d")));
        assertThat(queue.dequeue(), is(Optional.of("e")));

    }

    @Test
    public void testPoll() throws Exception {

    }

    @Test
    public void testPeek() throws Exception {

    }
}