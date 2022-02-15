/**
 * Name: Julian Noeske.
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

package main;

import java.util.ArrayList;

public class IDLList<E> {
    //Inner class
    private class Node<E> {
        //Data field
        private E data;
        private Node<E> next;
        private Node<E> prev;

        //Constructors
        public Node(E elem) { //this is a constructor that hold elem.
            this.data = elem;
            prev = null;
            next = null;
        }

        public Node(E elem, Node<E> prev, Node<E> next) { //this is a constructor that hold elem, prev, and next.
            this.data = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    //Data field
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    //Operations
    public IDLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indices = new ArrayList<>();
    }

    public boolean add(int index, E elem) { //this is a function that add a value at the index position.
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index should not be negative or greater than the length of the list.");
        }
        else if (index == 0) {
            add(elem); //if the index is zero, just call the function add(E elem).
        }
        else {
            Node<E> current = indices.get(index);
            Node<E> newCurrent = new Node<>(elem, current, current.prev);
            current.prev.next = newCurrent;
            current.prev = newCurrent;
            size++;
            indices.add(index, newCurrent);
        }
        return true;
    }

    public boolean add(E elem) {
        if (head == null) { //if the head is empty.
            head = new Node<E>(elem);
            tail = head;
        }
        else if (head == tail) {
            head = new Node<E>(elem, tail, null);
            tail.prev = head;
        }
        else {
            head = new Node<E>(elem, head, null);
            head.next.prev = head;
        }

        indices.add(0, head);
        size++;
        return true;
    }

    public boolean append(E elem) {
        if (head == null) { // Empty list
            head = new Node<E>(elem);
            tail = head;
            size++;
            return indices.add(head);
        }

        if (head == tail) { // Singleton list
            tail = new Node<E>(elem, null, head);
            head.next = tail;
            size++;
            return indices.add(tail);
        }

        tail.next = new Node<E>(elem, null, tail);
        tail = tail.next;
        size++;
        return indices.add(tail);
    }

    public E get(int index){
        return (tail.data); //like in python, return list[index].
    }

    public E getHead(){
        if (head == null) { //if the list is empty.
            throw new IllegalArgumentException("This is an empty list!"); //throw an error.
        }
        else {
            return head.data; //return the head of the list.
        }
    }

    public E getTail(){
        if (tail == null) { //if the list is empty.
            throw new IllegalArgumentException("This is an empty lst!"); // throw an error.
        }
        else {
            return tail.data; //return the tail of the list.
        }
    }

}
