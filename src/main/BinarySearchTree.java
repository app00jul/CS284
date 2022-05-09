package main;

import com.sun.source.tree.BinaryTree;

import java.util.Stack;

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

    /*
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
     */

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
        Stack<Node> tree = new Stack<Node>();
        tree.push(root);
        int numOfBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("\n");

        while (isRowEmpty == false) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;

            for (int x = 0; x < numOfBlanks; x++)
                System.out.print(" ");

            while (tree.isEmpty() == false) {
                Node temp = (Node)tree.pop();
                if (temp != null)
                {
                    System.out.print(temp.value);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int y = 0; y < numOfBlanks*2-2; y++)
                    System.out.print(" ");
            }
            System.out.println();
            numOfBlanks /= 2;
            while (localStack.isEmpty() == false)
                tree.push(localStack.pop());

        }
        System.out.println();
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
        tree.display();
        tree.inorder();
    }
}

