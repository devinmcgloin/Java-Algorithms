package dataStructures;

/**
 * Simple non balancing BST that assumes natural ordering, uses inorder traversal and does not support custom
 * comparators.
 *
 * @author devinmcgloin
 * @version 11/11/15.
 */
public class BST<E extends Comparable<E>> {

    private BSTNode<E> root = null;
    private int size;
    private TRAVERSAL traversal = TRAVERSAL.inorder;

    public BST() {
        size = 0;
    }

    public BST(TRAVERSAL traversal) {
        size = 0;
        this.traversal = traversal;
    }

    public void setTraversal(final TRAVERSAL traversal) {
        this.traversal = traversal;
    }

    /**
     * Inserts the given element into the proper position. No balancing occurs.
     *
     * @param e element to be added
     */
    public void insert(E e) {
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
    private BSTNode<E> insert(E e, BSTNode<E> n) {
        if (n == null) {
            return new BSTNode<>(e);
        } else {
            if (n.data.compareTo(e) > 0) {
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
    public void remove(E e) {
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
    private BSTNode<E> remove(BSTNode<E> n, E e) {
        if (n == null) {
            return n;
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

    /**
     * takes care of all the logistics of actually severing the node from the rest of the tree
     *
     * @param n node to be removed
     *
     * @return the node that took the old nodes place.
     */
    private BSTNode<E> remove(BSTNode<E> n) {
        size--;
        if (n.left == null)
            return n.right;

        if (n.right == null)
            return n.left;

        E data = getPredecessor(n);
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
    private E getPredecessor(BSTNode<E> n) {
        if (n == root && n != null)
            return getPredecessor(n.left);
        else if (n.right == null)
            return n.data;
        else if (n.left == null)
            return getPredecessor(n.right);
        else return root.data;
    }

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

    /**
     * contains check for the whole tree
     *
     * @param e element to check for
     *
     * @return true if the element is present, otherwise false
     */
    public boolean contains(E e) {
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

    /**
     * returns a reference to the element present in the tree that equals the element passed in.
     *
     * @param e element searching for
     *
     * @return the element in the tree that equals the node passed in
     */
    public E get(E e) {
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
    private E get(BSTNode<E> n, E e) {
        if (n == null) {
            return null;
        }
        int cmp = n.data.compareTo(e);
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
    public boolean isEmpty() {
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
        if (traversal == TRAVERSAL.inorder) {
            inorderTraversal(root, buffer);
        } else if (traversal == TRAVERSAL.postorder) {
            postOrderTraversal(root, buffer);
        } else if (traversal == TRAVERSAL.preorder) {
            preOrderTraversal(root, buffer);
        }
        return buffer.append("]").toString().trim();
    }

    /**
     * traverses the tree added the nodes to a buffer in an inorder fashion.
     *
     * @param n      current node
     * @param buffer buffer to be added to
     */
    private void inorderTraversal(BSTNode<E> n, StringBuffer buffer) {
        if (n != null) {
            inorderTraversal(n.left, buffer);
            buffer.append(" ").append(n.toString()).append(" ");
            inorderTraversal(n.right, buffer);
        }
    }

    private void postOrderTraversal(BSTNode<E> n, StringBuffer buffer) {
        if (n != null) {
            postOrderTraversal(n.left, buffer);
            postOrderTraversal(n.right, buffer);
            buffer.append(" ").append(n.toString()).append(" ");
        }
    }

    private void preOrderTraversal(BSTNode<E> n, StringBuffer buffer) {
        if (n != null) {
            buffer.append(" ").append(n.toString()).append(" ");
            preOrderTraversal(n.left, buffer);
            preOrderTraversal(n.right, buffer);
        }
    }

    public String prettyPrint() {
        StringBuffer buffer = new StringBuffer();
        prettyPrint(root, buffer, 0);
        return buffer.toString();
    }

    private void prettyPrint(BSTNode<E> n, StringBuffer buffer, int depth) {
        buffer.append(pDepth(depth)).append(n.toString()).append("\n");
        if (n.isLeaf()) return;
        if (n.left != null)
            prettyPrint(n.left, buffer, depth + 1);
        if (n.right != null)
            prettyPrint(n.right, buffer, depth + 1);
    }

    private String pDepth(int depth) {
        String s = "";
        for (int i = 0; i < depth; i++) {
            s += "\t";
        }
        return s;
    }

    public enum TRAVERSAL {
        inorder, postorder, preorder
    }

    /**
     * Simple BST Node class that has references to a right and left node.
     *
     * @param <T>
     */
    private class BSTNode<T extends Comparable<T>> {
        T data;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T data) {
            this.data = data;
        }

        /**
         * comparison of two nodes compares their data inside.
         *
         * @param element element to be compared to
         *
         * @return ordering according the T compareTo
         */
        int compareTo(BSTNode<T> element) {
            return data.compareTo(element.data);
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