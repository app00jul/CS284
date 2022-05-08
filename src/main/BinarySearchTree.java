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

        public int get_height(){
            return height(this);
        }

        public int height(Node node){
            if (node == null){
                return -1;
            } else {
                return 1 + Math.max(height(node.left), height(node.right));
            }
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

    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);

        System.out.print(root.value + "  ");

        inorder(root.right);
    }

    public void display() {
        System.out.println("The output of you program is: ");
        display(root);
    }

    public void display(Node root) {
        if (root == null)
            return;
        int max_height = root.get_height();
        display(root.right);

        //then go for root node
        if (root.get_height() == 0){
            System.out.println("Max:" + max_height);
            System.out.println(root.value);
        } else if (root.get_height() == 1) {
            System.out.println("Max:" + max_height);
            System.out.println("    " + root.value);
        } else if (root.get_height() == 2) {
            System.out.println("Max:" + max_height);
            System.out.println("        " + root.value);
        } else if (root.get_height() == 3) {
            System.out.println("Max:" + max_height);
            System.out.println("            " + root.value);
        }

        //next traverse right subtree recursively
        display(root.left);
    }

    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(9);
        tree.display();
        tree.inorder();
    }
}

