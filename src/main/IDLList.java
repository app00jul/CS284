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


    public boolean add(E elem){
        if (indices.isEmpty()) {
            Node<E> newNode = new Node<E>(elem, null, null);
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
            Node<E> oldfirst = indices.get(0);
            Node<E> newfirst = new Node<E>(elem, null, oldfirst);
            head = newfirst;
            oldfirst.prev = newfirst;
            size += 1;
            indices.add(null);
            for (int i = indices.size()-1; i > 0; i--) {
                indices.set((i),indices.get(i-1));
            }
            indices.set(0, newfirst);
        }
        return true;
    }


    public boolean add(int index, E elem){ //this is a function that add a value at the index position.
        // Invalid index, throw IndexOutOfBoundsException()
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("This index is invalid!");
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
            Node<E> prev_node = (indices.get(index).prev);
            Node<E> new_node = new Node<E>(elem, prev_node, current);
            prev_node.next = new_node;
            current.prev = new_node;
            size += 1;
            indices.add(null);
            for (int i = indices.size() - 1; i > index; i--) {
                indices.set((i), indices.get(i - 1));
            }
            indices.set(index, new_node);

        }
        return true;
    }


    public boolean append(E elem){
        // if the list is empty -> call add(elem)
        if (this.indices.isEmpty()){
            return add(elem);
        }
        // else:
        // get the old last node (which is also the tail)
        // create a new node: prev -> last node
        //                    next -> last node's next
        // for the old last node: the next of it is the new node
        // now the last node is the new node
        // update the indices and the size of the IDLList
        else {
            tail.next = new Node<E>(elem, null, tail);
            tail = tail.next;
        }
        size += 1;
        return indices.add(tail);
    }


    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Index is invalid!");
        }
        else if (index == 0){
            return head.data;
        }
        else if (index == size-1){
            return tail.data;
        }
        else {
            int count = 0;
            Node<E> current = head;
            while (current != null) {
                if (count == index) {
                    return current.data;
                } else {
                    count += 1;
                    current = current.next;
                }
            }
            return current.data;
        }
    }


    public E getHead(){
        if (this.indices.isEmpty()){ //if the list is empty.
            throw new IllegalArgumentException("This list is empty!"); //throw an error.
        }
        else{
            return head.data; //return the head of the list.
        }
    }


    public E getLast(){
        if (this.indices.isEmpty()){ //if the list is empty.
            throw new IllegalArgumentException("This list is empty!"); // throw an error.
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
            throw new IllegalStateException("This is NO head");
        }
        // if this list only has 1 node, return the data value of the head
        // update the variable values of the data filed
        else if (head == tail){
            Node<E> head_holder = head;
            head = null;
            tail = null;
            size -= 1;
            indices.clear();
            return head_holder.data;
        }
        // if more the one nodes:
        //     get the oldhead of the list
        //     if we remove the oldhead:
        //         the new head will be oldhead.next
        //         the prev of the new head will be null
        //         update the values of the data fields if needed
        //         return the data value of the head
        else{
            Node<E> head_holder = head;
            head = head.next;
            indices.remove(0);
            size -= 1;
            return head_holder.data;
        }
    }


    /**
     * This method removes and returns the element at the tail.
     * Should throw an IllegalStateException if there is no such element.
     * @return the data value of the tail being removed
     */
    public E removeLast() {
        // if the list is empty, throw IllegalStateException()
        if (this.indices.isEmpty()) { //Empty list
            throw new IllegalStateException("This list is empty!");
        }
        // if only 1 node in the list, call remove()
        else if (head == tail) {
            return remove();
        }
        // if more than 1 node
        //     get the oldTail of the list
        //     if we remove the oldtail:
        //         the new tail will be oldtail.prev
        //         the next of the new tail will be null
        //         update the values of the data fields if needed
        //         return the data value of the tail
        else {
            Node<E> tail_holder = tail;
            tail = tail.prev;
            tail.next = null;
            indices.remove(size - 1);
            size -= 1;
            return tail_holder.data;
        }
    }


    /**
     * This method removes and returns the element at the index.
     * @param index the index of the element to be removed
     * @return the data value of the node being removed
     */
    public E removeAt(int index) {
        // if there is no such element: throw IllegalStateException.
        if (index < 0 || index > size) { //Illegal index
            throw new IllegalStateException("This index is invalid!");
        }
        // if the node is the head or the tail
        // get current node (n), prev node of the current node (nPrev)
        // and next node of the current node (nNext)
        if (index == 0) { // Head
            return remove();
        }
        else if (index == size - 1) { // Tail
            return removeLast();
        }
        // if we remove the current node:
        //       nPrev.next -> n.next
        //       nNext.prev -> n.prev
        //       update the variable values in data fields
        else {
            Node<E> current = indices.remove(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size -= 1;
            return current.data;
        }
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
        if (elem.equals(head.data)) { // remove the first element
            remove();
            return true;
        }
        else if (elem.equals(tail.data)) { // remove the last element
            removeLast();
            return true;
        }
        // iterate from the head to the tail and compare every elem
        // if the elem is found, remove and return true;
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
            index += 1;
        }
        //else return false
        return false;
    }


    /**
     * This method resents a string representation of the list.
     * @return a string
     */
    public String toString() {
    //for example "9,8,7,6,5,4,3,2,1,0"
    //start from the empty string
    //add elem to the string
    //can use + to do concatenation
        Node<E> current = head;
        String str = "";
        while (current != tail) {
            str = str + current.data + ",";
            current = current.next;
        }
        str = str + current.data;
        return str;
    }
}
