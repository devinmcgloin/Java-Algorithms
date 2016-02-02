package dataStructures.interfaces;

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

    IList<E> getNeighbors(E vertex);

    void removeVertex(E vertex);

    void removeEdge(E vertexA, E vertexB);
}
