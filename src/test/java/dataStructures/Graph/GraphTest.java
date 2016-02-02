package dataStructures.Graph;

import dataStructures.Graph;
import dataStructures.interfaces.IGraph;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public class GraphTest {

    private IGraph<Integer> genGraph() {
        IGraph<Integer> g = new Graph<>();
        for (int i = 0; i < 6; i++) {
            g.addVertex(i);
        }
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        return g;
    }

    @Test
    public void testGetNumVertices() throws Exception {
        IGraph<Integer> g = genGraph();
        assertThat(g.getNumVertices(), is(6));
        g.addVertex(10);
        assertThat(g.getNumVertices(), is(7));
    }

    @Test
    public void testGetNumEdges() throws Exception {
        IGraph<Integer> g = genGraph();
        assertThat(g.getNumEdges(), is(5));
        g.addEdge(1, 4);
        assertThat(g.getNumEdges(), is(6));
        g.addEdge(4, 3);
        assertThat(g.getNumEdges(), is(6));

    }

    @Test
    public void testAddVertex() throws Exception {

    }

    @Test
    public void testAddEdge() throws Exception {

    }

    @Test
    public void testGetNeighbors() throws Exception {
        IGraph<Integer> g = genGraph();
        assertThat(g.getNeighbors(1).contains(0), is(true));
        assertThat(g.getNeighbors(1).contains(4), is(false));
    }
}