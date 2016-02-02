package dataStructures;

import dataStructures.interfaces.IGraph;
import dataStructures.interfaces.IList;
import dataStructures.interfaces.IMap;


/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public class Graph<E> implements IGraph<E> {

    IMap<Vertex<E>, IList<Edge<E>>> adjList = new HashMap<>();
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

    @Override
    public int getNumVertices() {
        return numVerts;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public void removeVertex(final E vertex) {

    }

    @Override
    public void removeEdge(final E vertexA, final E vertexB) {

    }

    /**
     * @param vertex
     */
    @Override
    public void addVertex(final E vertex) {
        Vertex<E> v = new Vertex<>(vertex);
        if (!adjList.containsKey(v)) {
            numVerts++;
            adjList.put(v, new LinkedList<Edge<E>>());
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
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);
        if (vertexA.equals(vertexB))
            return;
        if (!adjList.containsKey(vA))
            addVertex(vertexA);
        if (!adjList.containsKey(vB))
            addVertex(vertexB);
            if (t == TYPE.DIRECTED)
                addDirected(vertexA, vertexB);
            else
                addUndirected(vertexA, vertexB);
    }

    private void addDirected(final E vertexA, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);
        IList<Edge<E>> list = adjList.get(vA);


//        if (!list.contains(vB)) {
//            list.add(vB);
//            numEdges++;
//        }
    }

    private void addUndirected(final E vertexA, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);

        IList<Edge<E>> listA = adjList.get(vA);
        IList<Edge<E>> listB = adjList.get(vB);

//        if (!listA.contains(vertexB) && !listB.contains(vertexA)) {
//            listA.add(vertexB);
//            listB.add(vertexA);
//            numEdges++;
//        }

    }


    enum TYPE {
        DIRECTED, UNDIRECTED
    }

    public class Vertex<T>{
        T data;

        public Vertex(final T data) {
            this.data = data;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Vertex<?> vertex = (Vertex<?>) o;

            return data != null ? data.equals(vertex.data) : vertex.data == null;

        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }

    public class Edge<T>{
        Vertex<T> from;
        Vertex<T> to;
        double weight;

        public Edge(final Vertex<T> from, final Vertex<T> to, final double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
