package dataStructures;

import java.util.Comparator;

/**
 *
 * @author devinmcgloin
 * @version 11/24/15.
 */
public class AVLTree<T> {
    Comparator<T> comparator;
    private Node<T> root = null;
    private int size;

    public AVLTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private int height(Node<T> n) {
        if (n.isLeaf()) {
            n.balanceFactor = 0;
            return 0;
        }
        n.balanceFactor = height(n.left) - height(n.right);
        return n.balanceFactor;
    }

    /**
     * Inserts the given element into the proper position. No balancing occurs.
     *
     * @param e element to be added
     */
    public void insert(T e) {
        size++;
        root = insert(e, root);
    }

    /**
     * recursive insert call that traverses the tree and adds the node.
     *
     * @param e element to be added
     * @param n current node
     *
     * @return the current node
     */
    private Node<T> insert(T e, Node<T> n) {
        if (n == null) {
            return new Node<>(e);
        } else {
            if (comparator.compare(n.data, e) > 0) {
                n.left = insert(e, n.left);
            } else {
                n.right = insert(e, n.right);
            }
        }
        return n;
    }

    /**
     * Removes the given element from the tree
     *
     * @param e element to be removed
     */
    public void remove(T e) {
        root = remove(root, e);
    }

    /**
     * recursive remove call that traverses the tree and removes the node.
     *
     * @param n current node
     * @param e element to be removed
     *
     * @return current node
     */
    private Node<T> remove(Node<T> n, T e) {
        if (n == null) {
            return n;
        }
        int cmp = comparator.compare(n.data, e);
        if (cmp < 0) {
            n.left = remove(n.left, e);
        } else if (cmp > 0) {
            n.right = remove(n.right, e);
        } else {
            n = remove(n);
        }
        return n;
    }

    /**
     * takes care of all the logistics of actually severing the node from the rest of the tree
     *
     * @param n node to be removed
     *
     * @return the node that took the old nodes place.
     */
    private Node<T> remove(Node<T> n) {
        size--;
        if (n.left == null)
            return n.right;

        if (n.right == null)
            return n.left;

        T data = getPredecessor(n);
        n.data = data;
        n.left = remove(n.left, data);
        return n;
    }

    /**
     * gets the predecessor of the node passed in
     *
     * @param n node to get the predecessor of
     *
     * @return predecessor of n
     */
    private T getPredecessor(Node<T> n) {
        if (n == root && n != null)
            return getPredecessor(n.left);
        else if (n.right == null)
            return n.data;
        else if (n.left == null)
            return getPredecessor(n.right);
        else return root.data;
    }

    /**
     * gets the successor of the node passed in
     *
     * @param n node to get the successor of
     *
     * @return successor of n
     */
    private T getSuccessor(Node<T> n) {
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

    /**
     * contains check for the whole tree
     *
     * @param e element to check for
     *
     * @return true if the element is present, otherwise false
     */
    public boolean contains(T e) {
        return contains(root, e);
    }

    /**
     * recursive call that checks the rest of the tree
     *
     * @param n current node
     * @param e element searching for
     *
     * @return true if the element is present, otherwise false
     */
    private boolean contains(Node<T> n, T e) {
        if (n == null) {
            return false;
        }
        int cmp = comparator.compare(n.data, e);
        if (cmp == 0) {
            return true;
        } else if (cmp > 0) {
            return contains(n.left, e);
        } else
            return contains(n.right, e);
    }

    /**
     * returns a reference to the element present in the tree that equals the element passed in.
     *
     * @param e element searching for
     *
     * @return the element in the tree that equals the node passed in
     */
    public T get(T e) {
        return get(root, e);
    }

    /**
     * recursive call that traverses the tree to determine if the node is present or not, if it is, then it returns that
     * value
     *
     * @param n current node
     * @param e element searching for
     *
     * @return the element in the tree that equals the node passed in
     */
    private T get(Node<T> n, T e) {
        if (n == null) {
            return null;
        }
        int cmp = comparator.compare(n.data, e);
        if (cmp > 0) {
            return get(n.left, e);
        } else if (cmp < 0) {
            return get(n.right, e);
        } else return n.data;
    }

    /**
     * empties the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * checks if the tree is empty or not.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isTmpty() {
        return root == null;
    }

    /**
     * size of the tree call.
     *
     * @return size of the tree
     */
    public int size() {
        return size;
    }


    /**
     * toString method that returns the inorder traversal of the tree, surrounded by brackets.
     *
     * @return inorder representation of the tree.
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer().append("[");
        inorderTraversal(root, buffer);
        return buffer.append("]").toString().trim();
    }

    /**
     * traverses the tree added the nodes to a buffer in an inorder fashion.
     *
     * @param n      current node
     * @param buffer buffer to be added to
     */
    private void inorderTraversal(Node<T> n, StringBuffer buffer) {
        if (n != null) {
            inorderTraversal(n.left, buffer);
            inorderTraversal(n.right, buffer);
            buffer.append(" ").append(n.toString()).append(" ");
        }
    }


    /**
     * Simple Node class that has references to a right and left node.
     *
     * @param <T>
     */
    private class Node<T> {
        Integer balanceFactor = null;
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }

        /**
         * leaf test
         *
         * @return true if both the left and right nodes are null
         */
        boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * toString as defined in T
         *
         * @return the standard toString for the given class.
         */
        public String toString() {
            return data.toString();
        }
    }
}
