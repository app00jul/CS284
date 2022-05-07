package main;

import com.sun.source.tree.BinaryTree;

public class BinarySearchTree<E extends Comparable<E>>{
    public class Node{
        public int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, int newData) {
        // Base Case: root is null or not
        if (root == null) {
            root = new Node(newData);
            return root;
        }
        // Here checking for root data is greater or equal to newData or not
        else if (root.value >= newData) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, newData);
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, newData);
        }
        return root;
    }

    public void inorder() {
        System.out.println("Inorder:");
        inorder(root);
    }

    public void inorder(Node root) { // need to do inorder instead
        if (root == null)
            return;
        //first traverse left subtree recursively
        inorder(root.left);

        //then go for root node
        System.out.print(root.value + ", ");

        //next traverse right subtree recursively
        inorder(root.right);
    }

    public void display() {
        System.out.println("The output of you program is: ");
        display(root);
    }

    public void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.value + "     ");
        display(root.left);

        //then go for root node
        System.out.println();

        //next traverse right subtree recursively
        display(root.right);
    }

    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(8);
        tree.insert(1);
        tree.insert(2);
        tree.insert(7);
        tree.display();
        tree.inorder();
    }
}