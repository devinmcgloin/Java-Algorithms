package dataStructures.graph;

/**
 * @author devinmcgloin
 * @version 2/17/16.
 */
public class Vertex<T> {
    T data;

    public Vertex(final T data) {
        this.data = data;
    }


    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Vertex<?> vertex = (Vertex<?>) o;

        return data != null ? data.equals(vertex.data) : vertex.data == null;

    }


    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}