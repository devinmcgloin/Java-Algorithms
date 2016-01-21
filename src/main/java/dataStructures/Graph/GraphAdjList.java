package dataStructures.Graph;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public class GraphAdjList<E> implements IGraph<E> {
    Map<E, List<E>> adjList = new Hashtable<>();
    private int numVerts;
    private int numEdges;
    private TYPE t;

    public GraphAdjList() {
        numEdges = 0;
        numVerts = 0;
        t = TYPE.UNDIRECTED;
    }

    public GraphAdjList(TYPE t) {
        this();
        this.t = t;
    }

    @Override
    public int getNumVertices() {
        return numVerts;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public void deleteVertex(final E vertex) {

    }

    @Override
    public void deleteEdge(final E vertexA, final E vertexB) {

    }

    /**
     * @param vertex
     */
    @Override
    public void addVertex(final E vertex) {
        if (!adjList.containsKey(vertex)) {
            numVerts++;
            adjList.put(vertex, new LinkedList<E>());
        }
    }

    /**
     * todo need to check if edge is already present.
     *
     * @param vertexA
     * @param vertexB
     */
    @Override
    public void addEdge(final E vertexA, final E vertexB) {
        if (vertexA.equals(vertexB))
            return;
        if (!adjList.containsKey(vertexA))
            addVertex(vertexA);
        else if (!adjList.containsKey(vertexB))
            addVertex(vertexB);
        else {
            if (t == TYPE.DIRECTED)
                addDirected(vertexA, vertexB);
            else
                addUndirected(vertexA, vertexB);
        }
    }

    private void addDirected(final E vertexA, final E vertexB) {
        List<E> list = adjList.get(vertexA);
        if (!list.contains(vertexB)) {
            list.add(vertexB);
            numEdges++;
        }
    }

    private void addUndirected(final E vertexA, final E vertexB) {
        List<E> listA = adjList.get(vertexA);
        List<E> listB = adjList.get(vertexB);

        if (!listA.contains(vertexB) && !listB.contains(vertexA)) {
            listA.add(vertexB);
            listB.add(vertexA);
            numEdges++;
        }

    }

    @Override
    public List<E> getNeighbors(final E vertex) {
        return adjList.get(vertex);
    }

    enum TYPE {
        DIRECTED, UNDIRECTED
    }
}
