package dataStructures.interfaces;

import java.util.List;
import java.util.Set;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public interface IGraph<E> {

    int getNumVertices();

    int getNumEdges();

    void addVertex(E vertex);

    void addEdge(E vertexA, double edgeWeight, E vertexB);

    List<E> getNeighbors(E vertex);

    void removeVertex(E vertex);

    void removeEdge(E vertexA, E vertexB);

    boolean containsVertex(E vertex);

    Set<E> getVerticies();

}
