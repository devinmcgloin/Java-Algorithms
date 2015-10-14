package dataStructures;

import java.util.LinkedList;
import java.util.Optional;

/**
 * @author devinmcgloin
 * @version 10/14/15.
 */
public class Stack<E> {
    private LinkedList<E> stack = new LinkedList<E>();
    private int size = 0;

    public void push(E item) {
        stack.add(item);
        size++;
    }

    public Optional<E> peek() {
        if (empty())
            return Optional.empty();
        return Optional.of(stack.get(size));
    }

    public Optional<E> pop() {
        if (empty())
            return Optional.empty();
        E tmp = stack.get(size);
        size--;
        return Optional.of(tmp);
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size <= -1;
    }

    public int search(E item) {
        for (int i = size; i > 0; i--) {
            if (stack.get(i).equals(item)) {
                return size - i;
            }
        }
        return -1;
    }
}
