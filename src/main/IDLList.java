/**
 * Name: Julian Noeske.
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

package main;

import java.util.ArrayList;

public class IDLList<E>{
    //Inner class
    private class Node<E>{
        //Data field
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E elem){
            this.data = elem;
            next = null;
            prev = null;
        }

        public Node(E elem, Node<E> next, Node<E> prev) {
            this.data = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    //Data field
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    //Operations
    public IDLList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indices = new ArrayList<>();
    }

    public boolean add(int index, E elem){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("From public boolean add_1");
        }

        if (index == 0) {
            add(elem);
        } else {
            Node<E> current = indices.get(index);
            Node<E> newCurrent = new Node<>(elem, current, current.prev);
            current.prev.next = newCurrent;
            current.prev = newCurrent;
            size++;
            indices.add(index, newCurrent);
        }
        return true;
    }

    public boolean add(E elem){
        if (head == null) {
            head = new Node<E>(elem);
            tail = head;
        } else if (head == tail) {
            head = new Node<E>(elem, tail, null);
            tail.prev = head;
        } else {
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

    public E getHead() {
        // Empty list
        if (head == null)
            throw new IllegalArgumentException("Empty list!");
        return head.data;
    }

}
