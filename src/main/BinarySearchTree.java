package main;

import com.sun.source.tree.BinaryTree;

public class BinarySearchTree<E>{
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

    public Node insert(int new_data) {
        Node node = new Node(new_data);
        Node current, parent;

        if (root == null) {
            root = node;
            return root;
        } else {
            current = root;
            while (true) {
                parent = current;
                if (new_data < current.value) {
                    current = current.left;

                    if (current == null) {
                        parent.left = node;
                        return parent;
                    }
                } else {
                    current = current.right;

                    if (current == null) {
                        parent.right = node;
                        return parent;
                    }
                }
            }
        }
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

    public void display(String prefix, Node node, boolean is_left) {
        if (node != null) {
            display(prefix + "     ", node.right, false);
            System.out.println (prefix + ("") + node.value);
            display(prefix + "     ", node.left, true);
        }
    }

    public void display() {
        display("",this.root, false);
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

