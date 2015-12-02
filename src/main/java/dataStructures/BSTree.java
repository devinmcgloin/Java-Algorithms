package dataStructures;

import java.util.Comparator;

/**
 * @author devinmcgloin
 * @version 11/11/15.
 */
public class BSTree<E extends Comparable<E>> {

    BSTNode<E> root = null;
    int size;

    public BSTree() {
        size = 0;
    }

    public void insert(E e) {
        size++;
        root = insert(e, root);
    }

    private BSTNode<E> insert(E e, BSTNode<E> n) {
        if (n == null) {
            return new BSTNode<E>(e);
        } else {
            if (n.data.compareTo(e) > 0) {
                n.left = insert(e, n.left);
            } else {
                n.right = insert(e, n.right);
            }
        }
        return n;
    }

    public void remove(E e) {
        size--;
        root = remove(root, e);
    }

    private BSTNode<E> remove(BSTNode<E> n, E e) {
        if (n == null) {

        }

        int cmp = n.data.compareTo(e);
        if (cmp < 0) {
            n.left = remove(n.left, e);
        } else if (cmp > 0) {
            n.right = remove(n.right, e);
        } else {
            n = remove(n);
        }
        return n;
    }

    private BSTNode<E> remove(BSTNode<E> n) {
        if (n.left == null)
            return n.right;

        if (n.right == null)
            return n.left;

        E data = getPredicessor(n);
        n.data = data;
        n.left = remove(n.left, data);
        return n;
    }

    /**
     * todo deal with unlinking the node here
     *
     * @param n
     *
     * @return
     */
    private E getPredicessor(BSTNode<E> n) {
        if (n == root && n != null) {
            return getPredicessor(n.left);
        } else if (n.right == null) {
            return n.data;
        } else if (n.left == null) {
            return getPredicessor(n.right);
        } else {
            return root.data;
        }
    }

    /**
     * todo deal with unlinking the node here
     *
     * @param n
     *
     * @return
     */
    private E getSuccessor(BSTNode<E> n) {
        if (n == root && n != null) {
            return getSuccessor(n.right);
        } else if (n.left == null) {
            return n.data;
        } else if (n.right == null) {
            return getSuccessor(n.left);
        } else {
            return root.data;
        }
    }

    private void unlinkNode(BSTNode<E> n, BSTNode<E> child) {
        if (n.left == child) {
            n.left = null;
        } else if (n.right == child) {
            n.right = null;
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(BSTNode<E> n, E e) {
        if (n == null) {
            return false;
        }
        int cmp = n.data.compareTo(e);
        if (cmp == 0) {
            return true;
        } else if (cmp > 0) {
            return contains(n.left, e);
        } else
            return contains(n.right, e);
    }

    public boolean contains(E e, Comparator<E> comparator) {
        return contains(root, e, comparator);
    }

    private boolean contains(BSTNode<E> n, E e, Comparator<E> comparator) {
        if (n == null) {
            return false;
        }
        int cmp = comparator.compare(n.data, e);
        if (cmp == 0) {
            return true;
        } else if (cmp > 0) {
            return contains(n.left, e);
        } else {
            return contains(n.right, e);
        }
    }

    public E get(E e) {
        return get(root, e);
    }

    private E get(BSTNode<E> n, E e) {
        if (n == null) {
            return null;
        }
        int cmp = n.data.compareTo(e);
        if (cmp < 0) {
            return get(n.left, e);
        } else if (cmp > 0) {
            return get(n.right, e);
        } else return n.data;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }


    private class BSTNode<T extends Comparable<T>> {
        T data;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T data) {
            this.data = data;
        }

        int compareTo(BSTNode<T> element) {
            return data.compareTo(element.data);
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

}
