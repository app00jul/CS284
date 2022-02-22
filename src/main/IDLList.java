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

        //Constructors
        public Node(E elem){ //this is a constructor that hold elem.
            this.data = elem;
            prev = null;
            next = null;
        }

        public Node(E elem, Node<E> prev, Node<E> next){ //this is a constructor that hold elem, prev, and next.
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
    public IDLList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indices = new ArrayList<>();
    }

    public boolean add(int index, E elem){ //this is a function that add a value at the index position.
        // Invalid index, throw IndexOutOfBoundsException()
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // if the index is 0, use the add(E elem) to add elem at head
        if (index == 0) { //Head
            add(elem);
        }
        // else if the index is this.size - 1, the elem is added at the tail
        else if (this.size == -1){
            append(elem);
        }
        // else:
        //     get the current node at the input index and the prev node of current node
        //     create a new node: prev -> prev node of current node
        //                        next -> current node
        //     for the prev node of current node: the next of it is the new node
        //     for the current node: the prev is the new node
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

    public boolean add(E elem){
        if (indices.isEmpty()) {
            Node <E> newNode = new Node <E> (elem, null, null);
            head = newNode;
            tail = newNode;
            indices.add(newNode);
            size = 1;
        }
        // if the list is not empty
        // get the reference of the first node. (oldfirst)
        // create a new node:
        //     the head point to this new node (newfirst)
        //     the next of this new node point to the old first node
        //     the prev of the oldfirst node point to the new node.
        else {
            Node <E> oldfirst = indices.get(0);
            Node <E> newfirst = new Node <E>(elem, null, oldfirst);
            head = newfirst;
            oldfirst.prev = newfirst;
            size += 1;
            indices.add(null);
            for (int i = indices.size()-1; i>0; i--) {
                indices.set((i),indices.get(i-1));
            }
            indices.set(0, newfirst);
        }
        return true;
    }

    public boolean append(E elem){
        if (head == null){ // Empty list
            head = new Node<E>(elem);
            tail = head;
            size++;
            return indices.add(head);
        }

        if (head == tail){ // Singleton list
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
        if (index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        else if (index == 0){
            return (head.data); //like in python, return list[index].
        }
        else {
            int count = 0; /* index of Node we are
                          currently looking at */
            Node<E> current = head;
            while (current != null)
            {
                if (count == index)
                    return current.data;
                count++;
                current = current.next;
            }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
            assert (false);
            return current.data;
        }
    }

    public E getHead(){
        if (head == null){ //if the list is empty.
            throw new IllegalArgumentException("This is NO head!"); //throw an error.
        }
        else{
            return head.data; //return the head of the list.
        }
    }

    public E getLast(){
        if (tail == null){ //if the list is empty.
            throw new IllegalArgumentException("This is NO tail!"); // throw an error.
        }
        else{
            return tail.data; //return the tail of the list.
        }
    }

    public int size(){
        return size;
    }

    public E remove(){
        // if there is no head (head is null), throw IllegalStateException();
        if (head == null){
            throw new IllegalArgumentException("This is NO head");
        }
        // if this list only has 1 node, return the data value of the head
        // update the variable values of the data filed
        else if (head == tail){
            Node<E> temp = head;
            head = null;
            tail = null;
            size--;
            indices.clear();
            return temp.data;
        }
        // if more the one nodes:
        //     get the oldhead of the list
        //     if we remove the oldhead:
        //         the new head will be oldhead.next
        //         the prev of the new head will be null
        //         update the values of the data fields if needed
        //         return the data value of the head
        else{
            Node<E> temp = head;
            head = head.next;
            indices.remove(0);
            size--;
            return temp.data;
        }
    }

    /**
     * This method removes and returns the element at the tail.
     * Should throw an IllegalStateException if there is no such element.
     * @return the data value of the tail being removed
     */
    public E removeLast() {
        // if the list is empty, throw IllegalStateException()

        // if only 1 node in the list, call remove()

        // if more than 1 node
        //     get the oldTail of the list
        //     if we remove the oldtail:
        //         the new tail will be oldtail.prev
        //         the next of the new tail will be null
        //         update the values of the data fields if needed
        //         return the data value of the tail

        if (head == null) { //Empty list
            throw new IllegalStateException();
        }

        if (head == tail) { //Singleton list
            Node<E> temp = tail;
            head = null;
            tail = null;
            size = 0;
            indices.clear();
            return temp.data;
        }

        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        indices.remove(size - 1);
        size--;
        return temp.data;
    }

    /**
     * This method removes and returns the element at the index.
     * @param index the index of the element to be removed
     * @return the data value of the node being removed
     */
    public E removeAt(int index) {
        // if there is no such element: throw IllegalStateException.
        // if the node is the head or the tail
        // get current node (n), prev node of the current node (nPrev)
        // and next node of the current node (nNext)
        // if we remove the current node:
        //       nPrev.next -> n.next
        //       nNext.prev -> n.prev
        //       update the variable values in data fields
        if (index < 0 || index > size) { //Illegal index
            throw new IllegalStateException("Illegal Index!");
        }

        if (index == 0) { // Head
            return remove();
        }

        if (index == size - 1) { // Tail
            return removeLast();
        }

        Node<E> current = indices.remove(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.data;
    }

    /**
     * This method removes the first occurrence of elem in the list
     * @param elem
     * @return returns true if elem was in the list, false if not.
     */
    public boolean remove(E elem) {
        //if the list is empty : throw IllegalStateException()

        // iterate from the head to the tail and compare every elem
        // if the elem is found, remove and return true; else return false
        if (elem.equals(head.data)) { // remove the first element
            remove();
            return true;
        }

        if (elem.equals(tail.data)) { // remove the last element
            removeLast();
            return true;
        }

        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(elem)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                indices.remove(index);
                size--;
                return true;
            }
            current = current.next;
            index++;
        }

        return false;
    }

    /**
     * This method resents a string representation of the list.
     * @return a string
     */
    public String toString() {
//        for example "9,8,7,6,5,4,3,2,1,0"
//        start from the empty string
//        add elem to the string
//        can use + to do concatenation
        Node<E> current = head;
        String s = "";
        while (current != null) {
            s = s + current.data + ",";
            current = current.next;
        }
        s.substring(0,s.length()-2);
        return s;
    }

}
