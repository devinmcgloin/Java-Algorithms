package dataStructures.graph;


import java.util.*;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public class Graph<E> {

    Map<Vertex<E>, List<Edge<E>>> adjList = new HashMap<>();
    private int numVerts;
    private int numEdges;
    private TYPE t;

    public Graph() {
        numEdges = 0;
        numVerts = 0;
        t = TYPE.UNDIRECTED;
    }

    public Graph(TYPE t) {
        this();
        this.t = t;
    }


    public int getNumVertices() {
        return numVerts;
    }


    public int getNumEdges() {
        return numEdges;
    }


    public void removeVertex(final Vertex<E> vertex) {
        adjList.remove(vertex);
        for (List<Edge<E>> list : adjList.values()) {
            for (Iterator<Edge<E>> iter = list.iterator(); iter.hasNext(); ) {
                Edge<E> edge = iter.next();
                if (edge.from.equals(vertex) || edge.to.equals(vertex))
                    iter.remove();
            }
        }
    }


    public double getWeight(final Vertex<E> vertexA, final Vertex<E> vertexB) {
        for (Edge<E> edge : adjList.get(vertexA)) {
            if (edge.from.equals(vertexA) && edge.to.equals(vertexB)) {
                return edge.weight;
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    /**
     * for undirected graphs this function removes both edges between vertexA and vertexB. For directed graphs, it only removes the edge from vertexA to vertexB.
     *
     * @param vertexA
     * @param vertexB
     */

    public void removeEdge(final Vertex<E> vertexA, final Vertex<E> vertexB) {
        for (Iterator<Edge<E>> iter = adjList.get(vertexA).iterator(); iter.hasNext(); ) {
            Edge<E> edge = iter.next();
            if (edge.from.equals(vertexA) && edge.to.equals(vertexB)) {
                iter.remove();
            }
        }

        if (t == TYPE.UNDIRECTED) {
            for (Iterator<Edge<E>> iter = adjList.get(vertexB).iterator(); iter.hasNext(); ) {
                Edge<E> edge = iter.next();
                if (edge.from.equals(vertexB) && edge.to.equals(vertexA)) {
                    iter.remove();
                }
            }
        }
    }


    public boolean containsVertex(final Vertex<E> vertex) {
        for (Vertex<E> v : adjList.keySet()) {
            if (vertex.equals(v))
                return true;
        }
        return false;
    }


    public Set<Vertex<E>> getVerticies() {
        Set<Vertex<E>> hashSet = new HashSet<>();
        for (Vertex<E> v : adjList.keySet())
            hashSet.add(v);
        return hashSet;
    }


    /**
     * @param vertex
     */

    public void addVertex(final E vertex) {
        Vertex<E> v = new Vertex<>(vertex);
        if (!adjList.containsKey(v)) {
            numVerts++;
            adjList.put(v, new LinkedList<Edge<E>>());
        }
    }

    public Optional<Vertex<E>> getVertex(E item) {
        return adjList.keySet().stream().filter(vertex -> vertex.data.equals(item)).findFirst();
    }

    /**
     *
     * @param vertexA
     * @param vertexB
     */

    public void addEdge(final E vertexA, final double edgeWeight, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);
        if (vertexA.equals(vertexB))
            return;
        if (!adjList.containsKey(vA))
            addVertex(vertexA);
        if (!adjList.containsKey(vB))
            addVertex(vertexB);
            if (t == TYPE.DIRECTED)
                addDirected(vertexA, edgeWeight, vertexB);
            else
                addUndirected(vertexA,edgeWeight, vertexB);
    }

    private void addDirected(final E vertexA, double weight, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);
        List<Edge<E>> list = adjList.get(vA);

        if (!list.contains(vB)) {
            Edge<E> edge = new Edge<>(vA, weight, vB);
            list.add(edge);
            numEdges++;
        }
    }

    private void addUndirected(final E vertexA, double weight, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);

        List<Edge<E>> listA = adjList.get(vA);
        List<Edge<E>> listB = adjList.get(vB);

        if (!listA.contains(vertexB) && !listB.contains(vertexA)) {
            Edge<E> edgeA = new Edge<>(vA, weight, vB);
            Edge<E> edgeB = new Edge<>(vB, weight, vA);

            listA.add(edgeA);
            listB.add(edgeB);
            numEdges++;
        }

    }

    public List<Vertex<E>> getNeighbors(final Vertex<E> vertex) {
        List<Edge<E>> l = adjList.get(vertex);
        List<Vertex<E>> ll = new LinkedList<>();
        for(Edge<E> edge : l){
            ll.add(edge.to);
        }
        return ll;
    }

    public enum TYPE {
        DIRECTED, UNDIRECTED
    }


}


