package dataStructures.markov;

import dataStructures.Tuple;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author devinmcgloin
 * @version 2/17/16.
 */
public class MarkovChain<E> {
    static Logger logger = Logger.getLogger(MarkovChain.class);

    Hashtable<E, MarkovState<E>> stateSpace = new Hashtable<>();
    Random r = new Random();


    public MarkovChain() {

    }

    public static void main(String[] args) {
        MarkovChain<String> m = new MarkovChain<>();
        MarkovLoader.loadMarkov(m, "/Users/devinmcgloin/projects/Java-Algorithms/src/main/resources/simpleMarkov");


        String start = "b";
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(start);
            start = m.getNext(start);
        }
        logger.debug(list);
    }

    public boolean addState(E state) {
        if (!stateSpace.containsKey(state)) {
            stateSpace.put(state, new MarkovState<E>(state));
            return true;
        } else return false;
    }

    public boolean addState(E startState, double weight, E endState) {
        addState(startState);
        addState(endState);
        stateSpace.get(startState).addEdge(weight, stateSpace.get(endState));
        return true;
    }

    public E getNext(E current) {
        MarkovState<E> markovState = stateSpace.get(current);
        double selection = r.nextDouble();
        for (Tuple<Double, MarkovState<E>> item : markovState.getEdges()) {
            if (item.getItemA() >= selection) {
                return item.getItemB().getElement();
            } else {
                selection -= item.getItemA();
            }
        }
        return null;
    }

}
