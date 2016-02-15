package graph;

import dataStructures.Graph;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class AStar {
    static Logger logger = Logger.getLogger(Dijkstra.class);

    private AStar() {
    }

    public static <E> List<E> AStar(Graph<E> map, E start, E goal) {
        return null;
    }


    public static void main(String[] args) {
        Graph<String> g = new Graph<>(Graph.TYPE.DIRECTED);
        GraphLoader.loadGraph(g, "/Users/devinmcgloin/projects/Java-Algorithms/src/main/resources/simpleWeightedGraph");

        System.out.println(AStar(g, "a", "g"));
    }
}
