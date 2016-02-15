package graph;

import dataStructures.Graph;

import java.util.*;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class Dijkstra {

    private Dijkstra() {
    }

    public static <E> List<E> Dijkstra(Graph<E> map, E start, E goal) {
        // Edge case if start is equal to the goal.
        if (start.equals(goal)) {
            List<E> list = new LinkedList<>();
            list.add(goal);
            return list;
        }

        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        HashSet<E> visited = new HashSet<>();
        HashMap<E, E> hashMap = new HashMap<>();


        return null;
    }
}
