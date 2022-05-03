package main;

import com.sun.source.tree.BinaryTree;

public class BinarySearchTree<E extends Comparable<E>>{
    protected class Node<E>{
        public int value;
        Node<E> left;
        Node<E> right;
        int depth;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        protected void set_depth(int depth) {
            this.depth = depth;
        }

        protected int get_depth() {
            return this.depth;
        }
    }

    public Node<E> root;

    public void insert_value(double k, BinaryTree T){
        Node<E> parent = find_parent(k, T.root);

        if (k <= parent.value){
            if (parent.left == null){
                //TO DO
            } else{
                //TO DO
            }
        } else{
            if (parent.right == null){
                //TO DO
            } else{
                //TO DO
            }
        }
    }

    public void find_parent(double k, Node v){
        if (k <= v.value && T.left(v) == null){
            return v;
        } else if (k > v.value && T.right(v) == null){
            return v;
        } else{
            if (k <= v.value){
                find_parent(k, T.left(v));
            } else{
                find_parent(k, T.right(v));
            }
        }
    }

    public static void main(String args[]){
        System.out.println("Hello there!");
    }
}