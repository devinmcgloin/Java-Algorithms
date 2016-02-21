package dataStructures.graph;

/**
 * @author devinmcgloin
 * @version 2/17/16.
 */
public class Edge<P> {
    Vertex<P> from;
    Vertex<P> to;
    double weight;

    public Edge(final Vertex<P> from, final double weight, final Vertex<P> to) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
