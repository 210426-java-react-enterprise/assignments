package com.revature.project0.util;

/**
 * A simple implementation of a doubly linked-list structure that
 * does not accept null data.
 *
 * @param <T>
 */

public class LinkedList<T> implements Queue<T>, List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Add generic type into linked list, adding to end of list.
     *
     */
    @Override
    public void add(T data) throws IllegalArgumentException{

        if (data == null){
            throw new IllegalArgumentException("This linked list does not accept null values.");
        }

        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            tail = head = newNode; // sets both the head and tail equal to the new node
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }

        size++;

    }


    /**
     * Get generic data from node in linked list.
     *
     * @return T
     */
    @Override
    public T get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The provided index would be out of bounds.");
        }

        Node<T> runner = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return runner.data;
            }
            runner = runner.nextNode;
        }

        return null;

    }


    /**
     * Add generic type into linked list.
     *
     * @return boolean
     */
    @Override
    public boolean contains(T data)  throws IllegalArgumentException {

        if (data == null){
            throw new IllegalArgumentException("This linked list does not accept null values.");
        }

        Node<T> runner = head;
        for (int i = 0; i < size; i++) {
            if(i == 0){
                runner = head;
            }else{
                runner = runner.nextNode;
            }

            if (runner.data.equals(data)){
                return true;
            }
        }
        return false;

    }


    /**
     * Get size of linked list.
     *
     * @return int
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Returns and removes the head node's data or else returns null.
     *
     * @return T
     */
    @Override
    public T poll() {

        if (head == null) {
            return null;
        }

        T soughtData = head.data;
        head = head.nextNode;

        if (head != null) {
            head.prevNode = null;
        } else {
            tail = null;
        }

        size--;

        return soughtData;

    }


    /**
     * Returns generic data in head of linked list.
     *
     * @return T
     */
    @Override
    public T peek() {

        return head.data;

    }


    /**
     * Retrieves and removes the argument data in linked list.
     * Returns null if no data found.
     *
     * @return T
     */
    @Override
    public T remove(T data)  throws IllegalArgumentException {

        if (data == null){
            throw new IllegalArgumentException("This linked list does not accept null values.");
        }

        if (size == 0){
            return null;
        }

        Node<T> runner = head;

        for (int i = 0; i < size; i++) {//start from head and work towards tail
            if(i == 0){
                runner = head;
            }else{
                runner = runner.nextNode;
            }

            if (runner.data.equals(data)){
                if (size == 1){ //if head and tail are same node
                    head.nextNode = tail.prevNode = null;
                    tail.data = head.data = null;
                } else if (size == 2){ //if only 2 elements in list
                    head.nextNode = tail.prevNode = null;
                    head.data = tail.data;
                } else if(runner.equals(head)){ //if data in head
                   head.nextNode = head.nextNode.nextNode;
                   head.data = head.nextNode.nextNode.data;
                } else if (runner.equals(tail)){ //if data in tail
                    tail.prevNode = tail.prevNode.prevNode;
                    tail.data = tail.prevNode.prevNode.data;
                } else { //data is in middle of linked list

                    Node<T> node = head; //not a new node, but an existing one
                    for (int j = 0; j < i-1; j++){
                        node = node.nextNode;
                    }
                    node.nextNode = node.nextNode.nextNode;

                }

                return data;

            }
        }//end for loop

        throw new IllegalArgumentException("This linked list does not have this data.");

    }


    private static class Node<T> {

        T data;
        Node<T> nextNode; // defaults to null
        Node<T> prevNode; // defaults to null

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

    }

}
