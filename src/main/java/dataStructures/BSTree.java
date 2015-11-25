package dataStructures;

import java.util.Collection;

/**
 * @author devinmcgloin
 * @version 11/11/15.
 */
public class BSTree<E extends Comparable<E>> {

    BSTNode<E> root = null;
    int size;

    public BSTree(){size = 0;}

    public void add(E element){
        root = add(element, root);
    }

    private BSTNode<E> add(E element, BSTNode<E> n){
        if(n == null){
            return new BSTNode<E>(element);
        }else{
            if(n.data.compareTo(element) < 0){
                n.left =  add(element, n.left);
            }else{
                n.right = add(element, n.right);
            }
        }
        return n;
    }

    public void remove(E e){

    }

    public boolean contains(E e){
        return recContains(root, e);
    }

    private boolean recContains(BSTNode n, E e){
        if(n == null){
            return false;
        }
        int cmp = n.compareTo(e);
        if( cmp == 0) {
            return true;
        }else if(cmp < 0) {
            recContains(n.left, e);
        }else recContains(n.right, e);
        return false;
    }

    public void addAll(Collection<? extends E> c){

    }

    public void clear(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size;
    }


    class BSTNode<T extends Comparable<T>> {
        T data;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T data){
            this.data = data;
        }

        int compareTo(T element){
            return data.compareTo(element);
        }
    }

}
