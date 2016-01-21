package dataStructures.Graph;

import java.util.List;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public interface IGraph<E> {

    int getNumVertices();

    int getNumEdges();

    void addVertex(E vertex);

    void addEdge(E vertexA, E vertexB);

    List<E> getNeighbors(E vertex);

    void deleteVertex(E vertex);

    void deleteEdge(E vertexA, E vertexB);
}
