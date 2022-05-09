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

    public Node find(int search) {
        Node current = root;

        while (current.value != search) {
            if (search < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
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

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("") + n.value);
            print(prefix + "     ", n.left, true);
        }
    }

    public void print() {
        print("",this.root, false);
    }



    /*
    public void display() {
        System.out.println("The output of you program is: ");
        display(root);
    }

    public void display(Node root) {
        if (root == null)
            return;

        int max_height = this.root.get_height();
        String space = "    ";

        display(root.right);

        //then go for root node
        int current_height = max_height - root.get_height();
        //System.out.println("Height: " + root.get_height());
        System.out.println(space.repeat(current_height) + root.value);

        //next traverse right subtree recursively
        display(root.left);
    }
     */

    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(9);
        tree.print();
        tree.inorder();
    }
}

