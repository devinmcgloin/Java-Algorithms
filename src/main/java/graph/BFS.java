package graph;


import dataStructures.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class BFS {

    private BFS(){}

    public static <E> List<E> bfs(Graph<E> map, E start, E goal) {
        // Edge case if start is equal to the goal.
        if(start.equals(goal)) {
            List<E> list = new LinkedList<>();
            list.add(goal);
            return list;
        }

        //Initialize data structures
        HashSet<E> visited = new HashSet<>();
        LinkedList<E> queue = new LinkedList<>();
        HashMap<E, E> path = new HashMap<>();

        visited.add(start);
        queue.offer(start);

        while(!queue.isEmpty()){
            E current = queue.poll();

            //if we've found the goal, we loop through the map from the goal to the start position
            if(current.equals(goal)) {
                LinkedList<E> finalPath = new LinkedList<>();
                finalPath.add(goal);
                E g = path.get(goal);
                while(!g.equals(start)){
                    finalPath.addFirst(g);
                    g = path.get(g);
                }
                finalPath.addFirst(start);
                return finalPath;
            }

            // else we look at more neighbors
            for(E neigh : map.getNeighbors(current)){
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
        g.addEdge("a", 1, "b");
        g.addEdge("a", 1, "h");
        g.addEdge("b", 1, "h");
        g.addEdge("b", 1, "f");
        g.addEdge("c", 1, "d");
        g.addEdge("d", 1, "i");
        g.addEdge("d", 1, "g");
        g.addEdge("e", 1, "f");
        g.addEdge("e", 1, "g");
        g.addEdge("f", 1, "i");
        g.addEdge("a", 1, "d");

        System.out.println(bfs(g, "b", "c"));
    }
}
