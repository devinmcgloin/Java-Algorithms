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

    public static <E> IList<E> bfs(Graph<E> map, E start, E goal) {
        // Edge case if start is equal to the goal.
        if(start.equals(goal)) {
            IList<E> list = new LinkedList<>();
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

        return null;
    }
}
