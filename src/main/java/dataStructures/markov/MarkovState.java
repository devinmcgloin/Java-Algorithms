package dataStructures.markov;

import dataStructures.Tuple;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * todo not started
 * markov states handle the probabilities for each individual state, you can specify in terms of raw counts or percentage points.
 * todo what to do if percentage points dont add to one.
 *
 * @author devinmcgloin
 * @version 2/17/16.
 */
class MarkovState<E> {
    static Logger logger = Logger.getLogger(MarkovState.class);

    private E element;
    private LinkedList<Tuple<Double, MarkovState<E>>> states;

    protected MarkovState(E element) {
        this.element = element;
        states = new LinkedList<>();
    }

    protected List<Tuple<Double, MarkovState<E>>> getEdges() {
        return states;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MarkovState{");
        sb.append("element=").append(element);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final MarkovState<?> that = (MarkovState<?>) o;

        return element != null ? element.equals(that.element) : that.element == null;

    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }

    protected boolean addEdge(Double weight, MarkovState<E> to) {

        states.add(new Tuple<Double, MarkovState<E>>(weight, to));
        logger.debug(states);
        return true;
    }

    public E getElement() {
        return element;
    }
}
