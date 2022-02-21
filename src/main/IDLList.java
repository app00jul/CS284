/**
 * Name: Julian Noeske.
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System.
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

    public boolean add(E elem){
        if (this.indices.isEmpty()) { //if the head is empty.
            Node<E> new_node = new Node<E>(elem);
            head = new_node;
            tail = new_node;
            indices.add(new_node);
            size = 1;
        }
        else {
            Node<E> old_first = indices.get(0);
            Node<E> new_first = new Node<E>(elem,null,old_first);
            head = new_first;
            old_first.prev = new_first;
            size += 1;
            indices.add(null);
            for (int i = indices.size()-1; i>0; i--){
                indices.set((i),indices.get(i-1));
            }
            indices.set(0,new_first);
        }
        return true;
    }

    public boolean add(int index, E elem){ //this is a function that add a value at the index position.
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("The index should not be negative or greater than the length of the list.");
        }
        else if (index == 0){
            add(elem); //if the index is zero, just call the function add(E elem).
        }
        else{
            Node<E> current = indices.get(index);
            Node<E> newCurrent = new Node<>(elem, current, current.prev);
            current.prev.next = newCurrent;
            current.prev = newCurrent;
            size += 1;
            indices.add(index, newCurrent);
        }
        return true;
    }

    public boolean append(E elem){
        if (head == null){ // Empty list
            head = new Node<E>(elem);
            tail = head;
            size += 1;
            return indices.add(head);
        }

        if (head == tail){ // Singleton list
            tail = new Node<E>(elem, null, head);
            head.next = tail;
            size += 1;
            return indices.add(tail);
        }

        tail.next = new Node<E>(elem, null, tail);
        tail = tail.next;
        size += 1;
        return indices.add(tail);
    }

    public E get(int index){
        return (tail.data); //like in python, return list[index].
    }

    public E getHead(){
        if (this.indices.isEmpty()){ //if the list is empty.
            throw new IllegalArgumentException("This is NO head!"); //throw an error.
        }
        else{
            return head.data; //return the head of the list.
        }
    }

    public E getLast(){
        if (this.indices.isEmpty()) {
            throw new IllegalStateException("This list is empty");
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
        // if more the one nodes:
        //     get the oldhead of the list
        //     if we remove the oldhead:
        //         the new head will be oldhead.next
        //         the prev of the new head will be null
        //         update the values of the data fields if needed
        //         return the data value of the head
        if (head == tail){
            Node<E> temp = head;
            head = null;
            tail = null;
            size -= 1;
            indices.clear();
            return temp.data;
        }
        else{
            Node<E> temp = head;
            head = head.next;
            indices.remove(0);
            size -= 1;
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
        if (this.indices.isEmpty()){
            throw new IllegalArgumentException("This list is empty!");
        }
        // if only 1 node in the list, call remove()
        if (head == tail){
            return remove();
        }
        // if more than 1 node
        //     get the oldTail of the list
        //     if we remove the oldtail:
        //         the new tail will be oldtail.prev
        //         the next of the new tail will be null
        //         update the values of the data fields if needed
        //         return the data value of the tail
        else{
            Node<E> temp = tail;
            tail = tail.prev;
            indices.remove(size - 1);
            size -= 1;
            return temp.data;
        }
    }

    /**
     * This method removes and returns the element at the index.
     * @param index the index of the element to be removed
     * @return the data value of the node being removed
     */
    public E removeAt(int index) {
        // if there is no such element: throw IllegalStateException.
        if (index < 0 || index > size) {
            throw new IllegalStateException("Such index doesn't exist.");
        }

        if (index == 0){
            return remove();
        }
        Node<E> current = indices.remove(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size -= 1;
        return current.data;
    }

    /**
     * This method removes the first occurrence of elem in the list
     * @param elem
     * @return returns true if elem was in the list, false if not.
     */
    public boolean remove(E elem) {
        //if the list is empty : throw IllegalStateException()
        if (this.indices.isEmpty()){
            throw new IllegalStateException("This list is empty!");
        }
        // iterate from the head to the tail and compare every elem
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(elem)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                indices.remove(index);
                size -= 1;
                return true;
            }
            current = current.next;
            index++;
        }

        return false;
        // if the elem is found, remove and return true; else return false
    }

    /**
     * This method resents a string representation of the list.
     * @return a string
     */
    public String toString(){
    //for example "9,8,7,6,5,4,3,2,1,0"
    //start from the empty string
    //add elem to the string
    //can use + to do concatenation
        Node<E> current_elem = head;
        String str = "";
        while (current_elem != null){
            str = str + current_elem.data + ",";
            current_elem = current_elem.next;
        }
        return str;
    }
}
