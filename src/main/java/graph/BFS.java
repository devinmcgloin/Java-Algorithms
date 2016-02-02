package graph;

import dataStructures.Graph;
import dataStructures.LinkedList;
import dataStructures.HashMap;
import dataStructures.HashSet;
import dataStructures.Graph.Vertex;
import dataStructures.Graph.Edge;
import dataStructures.interfaces.IList;


/**
 * @author devinmcgloin
 * @version 2/2/16.
 */
public class BFS {

    private BFS(){}

    public static <E> IList<E> bfs(Graph<E> map, Graph.Vertex<E> start, Graph.Vertex<E> goal) {
        // Edge case if start is equal to the goal.
        if(start.equals(goal)) {
            IList<E> list = new LinkedList<>();
            list.add(goal);
            return list;
        }

        //Initialize data structures
        HashSet<Vertex<E>> visited = new HashSet<>();
        LinkedList<Vertex<E>> queue = new LinkedList<>();
        HashMap<Vertex<E>, Graph.Vertex<E>> path = new HashMap<>();

        visited.add(start);
        queue.offer(start);

        while(!queue.isEmpty()){
            Vertex<E> current = queue.poll();

            //if we've found the goal, we loop through the map from the goal to the start position
            if(current.equals( goal)) {
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
            for(Vertex<E> neigh : map.get(current)){
                if(visited.contains(neigh))
                    continue;
                visited.add(neigh);
                path.put(neigh, current); // from neigh to current as we want to back track when remaking the path.
                queue.offer(neigh);
            }


        }

        return null;
    }
}
