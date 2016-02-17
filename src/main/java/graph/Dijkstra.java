package graph;

import dataStructures.Tuple;
import dataStructures.graph.Graph;
import dataStructures.graph.Vertex;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class Dijkstra {
    static Logger logger = Logger.getLogger(Dijkstra.class);

    private Dijkstra() {
    }

    public static <E> List<Vertex<E>> Dijkstra(Graph<E> map, Vertex<E> start, Vertex<E> goal) {
        // Edge case if start is equal to the goal.
        if (start.equals(goal)) {
            List<Vertex<E>> list = new LinkedList<>();
            list.add(goal);
            return list;
        }

        Comparator<Tuple<Vertex<E>, Double>> cmp = new Comparator<Tuple<Vertex<E>, Double>>() {
            @Override
            public int compare(final Tuple<Vertex<E>, Double> o1, final Tuple<Vertex<E>, Double> o2) {
                return o1.getItemB().compareTo(o2.getItemB());
            }
        };

        PriorityQueue<Tuple<Vertex<E>, Double>> priorityQueue = new PriorityQueue<>(cmp);
        HashSet<Tuple<Vertex<E>, Double>> visited = new HashSet<>();
        HashMap<Vertex<E>, Vertex<E>> path = new HashMap<>();

        visited.add(new Tuple<Vertex<E>, Double>(start, 0.0));
        for (Vertex<E> item : map.getVerticies()) {
            priorityQueue.add(new Tuple<Vertex<E>, Double>(item, Double.POSITIVE_INFINITY));
        }
        priorityQueue.add(new Tuple<Vertex<E>, Double>(start, 0.0));

        while (!priorityQueue.isEmpty()) {
            Tuple<Vertex<E>, Double> current = priorityQueue.poll();
            logger.debug(current);

            if (!visited.contains(current)) {
                visited.add(current);

                //if we've found the goal, we loop through the map from the goal to the start position
                if (current.getItemA().equals(goal)) {
                    LinkedList<Vertex<E>> finalPath = new LinkedList<>();
                    finalPath.add(goal);
                    Vertex<E> g = path.get(goal);
                    while (!g.equals(start)) {
                        finalPath.addFirst(g);
                        g = path.get(g);
                    }
                    finalPath.addFirst(start);
                    return finalPath;
                }

                // else we look at more neighbors
                for (Vertex<E> neigh : map.getNeighbors(current.getItemA())) {
                    if (visited.contains(new Tuple<Vertex<E>, Double>(neigh, Double.POSITIVE_INFINITY))) {
                        continue;
                    }
                    visited.add(new Tuple<Vertex<E>, Double>(neigh, Double.POSITIVE_INFINITY));

                    path.put(neigh, current.getItemA()); // from neigh to current as we want to back track when remaking the path.
                    priorityQueue.add(new Tuple<Vertex<E>, Double>(neigh, current.getItemB() + map.getWeight(current.getItemA(), neigh)));

                }
            }


        }


        return null;
    }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(Graph.TYPE.DIRECTED);
        GraphLoader.loadGraph(g, "/Users/devinmcgloin/projects/Java-Algorithms/src/main/resources/simpleWeightedGraph");

        Optional<Vertex<String>> start = g.getVertex("a");
        Optional<Vertex<String>> end = g.getVertex("g");

        if (start.isPresent() && end.isPresent())
            System.out.println(Dijkstra(g, start.get(), end.get()));
    }


}