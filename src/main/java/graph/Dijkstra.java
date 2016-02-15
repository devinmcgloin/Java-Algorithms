package graph;

import dataStructures.Graph;
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

    public static <E> List<E> Dijkstra(Graph<E> map, E start, E goal) {
        // Edge case if start is equal to the goal.
        if (start.equals(goal)) {
            List<E> list = new LinkedList<>();
            list.add(goal);
            return list;
        }

        PriorityQueue<Node<E>> priorityQueue = new PriorityQueue<>();
        HashSet<E> visited = new HashSet<>();
        HashMap<E, E> path = new HashMap<>();

        visited.add(start);
        for (E item : map.getVerticies()) {
            priorityQueue.add(new Node<E>(item, Double.POSITIVE_INFINITY));
        }
        priorityQueue.add(new Node<E>(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node<E> current = priorityQueue.poll();
            logger.debug(current);

            if (!visited.contains(current)) {
                visited.add(current.item);

                //if we've found the goal, we loop through the map from the goal to the start position
                if (current.item.equals(goal)) {
                    LinkedList<E> finalPath = new LinkedList<>();
                    finalPath.add(goal);
                    E g = path.get(goal);
                    while (!g.equals(start)) {
                        finalPath.addFirst(g);
                        g = path.get(g);
                    }
                    finalPath.addFirst(start);
                    return finalPath;
                }

                // else we look at more neighbors
                for (E neigh : map.getNeighbors(current.item)) {
                    if (visited.contains(new Node<E>(neigh, Double.POSITIVE_INFINITY))) {
                        continue;
                    }
                    visited.add(neigh);

                    path.put(neigh, current.item); // from neigh to current as we want to back track when remaking the path.
                    priorityQueue.add(new Node<E>(neigh, current.weight + map.weight(current.item, neigh)));

                }
            }


        }


        return null;
    }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(Graph.TYPE.DIRECTED);
        GraphLoader.loadGraph(g, "/Users/devinmcgloin/projects/Java-Algorithms/src/main/resources/simpleWeightedGraph");

        System.out.println(Dijkstra(g, "a", "g"));
    }


}

class Node<T> implements Comparable<Node> {
    final T item;
    double weight = 0;

    public Node(final T item, final double weight) {
        this.item = item;
        this.weight = weight;
    }

    @Override
    public int compareTo(final Node o) {
        return Double.compare(weight, o.weight);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("weight=").append(weight);
        sb.append(", item=").append(item);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Node<?> node = (Node<?>) o;

        return item.equals(node.item);

    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }
}