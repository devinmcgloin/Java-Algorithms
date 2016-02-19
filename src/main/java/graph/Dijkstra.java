package graph;

import dataStructures.graph.Graph;
import dataStructures.graph.GraphLoader;
import dataStructures.graph.Vertex;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class Dijkstra {
    static Logger logger = Logger.getLogger(Dijkstra.class);

    private Dijkstra() {
    }

    /**
     * todo right now the visited set is useless, as the hash for tuple would have to be defined with a hash code just for object one.
     *
     * @param g
     * @param start
     * @param goal
     * @param <E>
     * @return
     */
    public static <E> List<Vertex<E>> Dijkstra(Graph<E> g, Vertex<E> start, Vertex<E> goal) {
        if (start.equals(goal)) {
            List<Vertex<E>> list = new ArrayList<>();
            list.add(start);
            return list;
        }


        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(Graph.TYPE.DIRECTED);
        GraphLoader.loadGraph(g, "/Users/devinmcgloin/projects/Java-Algorithms/src/main/resources/simpleWeightedGraph2");

        Optional<Vertex<String>> start = g.getVertex("a");
        Optional<Vertex<String>> end = g.getVertex("e");

        if (start.isPresent() && end.isPresent())
            System.out.println(Dijkstra(g, start.get(), end.get()));
        // should be 'a c d e'
    }


}

class Vert<E> {
    final Vertex<E> vertex;
    final Double weight;

    public Vert(final Vertex<E> vertex, final Double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vert{");
        sb.append("vertex=").append(vertex);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int hashCode() {
        return vertex != null ? vertex.hashCode() : 0;
    }

    public Double getWeight() {

        return weight;

    }

    public Vertex getVertex() {
        return vertex;
    }

}