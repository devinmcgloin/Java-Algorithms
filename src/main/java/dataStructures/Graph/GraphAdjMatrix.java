package dataStructures.Graph;

import java.util.List;

/**
 * @author devinmcgloin
 * @version 1/19/16.
 */
public class GraphAdjMatrix<E> implements IGraph<E> {

    private int numVerts;
    private int numEdges;
    private int[][] adjMatrix;

    public GraphAdjMatrix() {
        adjMatrix = new int[7][7];
        numEdges = 0;
        numVerts = 0;
    }

    @Override
    public int getNumVertices() {
        return numVerts;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public void addVertex(final E vertex) {

    }

    @Override
    public void addEdge(final E vertexA, final E vertexB) {

    }

    @Override
    public List<E> getNeighbors(final E vertex) {
        return null;
    }

    public void AddEdge(int v, int w) {
        numEdges++;
        adjMatrix[v][w] = 1;
    }

    public void AddVertex(int index) {
        numVerts++;
        int v = getNumVertices();
        if (index > v) {
            int[][] largeMatrix = new int[v * 2][v * 2];
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix[0].length; j++) {
                    largeMatrix[i][j] = adjMatrix[i][j];
                }
            }

        }
    }

    public List<Integer> getNeighbors(int v) {
        return null;
    }

    public String toString() {
        StringBuffer buff = new StringBuffer();
        int n = adjMatrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buff.append(adjMatrix[i][j] + " ");
            }
            buff.append("\n");
        }
        return buff.toString();
    }


}
