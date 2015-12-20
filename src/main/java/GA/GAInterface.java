package GA;

import java.util.Random;

/**
 * @author devinmcgloin
 * @version 12/18/15.
 */
public interface GAInterface<E> {
    Random r = new Random();

    double fitness();

}
