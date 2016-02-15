package dataStructures;


import dataStructures.interfaces.IGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.LinkedList;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public class Graph<E> implements IGraph<E> {

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
        Vertex<E> tmp = new Vertex<E>(vertex);
        adjList.remove(tmp);
        for (List<Edge<E>> list : adjList.values()) {
            for (Iterator<Edge<E>> iter = list.iterator(); iter.hasNext(); ) {
                Edge<E> edge = iter.next();
                if (edge.from.equals(tmp) || edge.to.equals(tmp))
                    iter.remove();
            }
        }
    }

    @Override
    public double weight(final E vertexA, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);

        for (Edge<E> edge : adjList.get(vA)) {
            if (edge.from.equals(vA) && edge.to.equals(vB)) {
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
    @Override
    public void removeEdge(final E vertexA, final E vertexB) {
        Vertex<E> vA = new Vertex<>(vertexA);
        Vertex<E> vB = new Vertex<>(vertexB);

        for (Iterator<Edge<E>> iter = adjList.get(vA).iterator(); iter.hasNext(); ) {
            Edge<E> edge = iter.next();
            if (edge.from.equals(vA) && edge.to.equals(vB)) {
                iter.remove();
            }
        }

        if (t == TYPE.UNDIRECTED) {
            for (Iterator<Edge<E>> iter = adjList.get(vB).iterator(); iter.hasNext(); ) {
                Edge<E> edge = iter.next();
                if (edge.from.equals(vB) && edge.to.equals(vA)) {
                    iter.remove();
                }
            }
        }
    }

    @Override
    public boolean containsVertex(final E vertex) {
        for (Vertex<E> v : adjList.keySet()) {
            if (vertex.equals(v.data))
                return true;
        }
        return false;
    }

    @Override
    public Set<E> getVerticies() {
        Set<E> hashSet = new HashSet<>();
        for (Vertex<E> v : adjList.keySet())
            hashSet.add(v.data);
        return hashSet;
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

    @Override
    public List<E> getNeighbors(final E vertex) {
        List<Edge<E>> l = adjList.get(new Vertex<>(vertex));
        List<E> ll = new LinkedList<>();
        for(Edge<E> edge : l){
            ll.add(edge.to.data);
        }
        return ll;
    }

    public enum TYPE {
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

    public class Edge<E>{
        Vertex<E> from;
        Vertex<E> to;
        double weight;

        public Edge(final Vertex<E> from, final double weight,  final Vertex<E> to) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
