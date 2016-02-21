package graph;


import dataStructures.graph.Graph;
import dataStructures.graph.GraphLoader;
import dataStructures.graph.Vertex;

import java.util.*;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class BFS {

    private BFS(){}

    public static <E> List<Vertex<E>> bfs(Graph<E> map, Vertex<E> start, Vertex<E> goal) {
        // Edge case if start is equal to the goal.
        if(start.equals(goal)) {
            List<Vertex<E>> list = new LinkedList<>();
            list.add(goal);
            return list;
        }

        //Initialize data structures
        HashSet<Vertex<E>> visited = new HashSet<>();
        LinkedList<Vertex<E>> queue = new LinkedList<>();
        HashMap<Vertex<E>, Vertex<E>> path = new HashMap<>();

        visited.add(start);
        queue.offer(start);

        while(!queue.isEmpty()){
            Vertex<E> current = queue.poll();

            //if we've found the goal, we loop through the map from the goal to the start position
            if(current.equals(goal)) {
                LinkedList<Vertex<E>> finalPath = new LinkedList<>();
                finalPath.add(goal);
                Vertex<E> g = path.get(goal);
                while(!g.equals(start)){
                    finalPath.addFirst(g);
                    g = path.get(g);
                }
                finalPath.addFirst(start);
                return finalPath;
            }

            // else we look at more neighbors
            for (Vertex<E> neigh : map.getNeighbors(current)) {
                if(visited.contains(neigh))
                    continue;
                visited.add(neigh);
                path.put(neigh, current); // from neigh to current as we want to back track when remaking the path.
                queue.offer(neigh);
            }


        }

        return new LinkedList<>();
    }

    public static void main(String[] args){
        Graph<String> g = new Graph<>();
        GraphLoader.loadGraph(g, "/Users/devinmcgloin/projects/Java-Algorithms/src/main/resources/simpleUnweightedGraph");


        Optional<Vertex<String>> start = g.getVertex("b");
        Optional<Vertex<String>> end = g.getVertex("c");

        if (start.isPresent() && end.isPresent())
            System.out.println(bfs(g, start.get(), end.get()));
    }
}
