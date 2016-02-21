package dataStructures;

/**
 * @author devinmcgloin
 * @version 2/17/16.
 */
public class Tuple<A, B> {
    final A itemA;
    final B itemB;

    public Tuple(final A itemA, final B itemB) {
        this.itemA = itemA;
        this.itemB = itemB;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tuple{");
        sb.append("itemA=").append(itemA);
        sb.append(", itemB=").append(itemB);
        sb.append('}');
        return sb.toString();
    }

    public B getItemB() {

        return itemB;
    }

    public A getItemA() {
        return itemA;
    }

}
