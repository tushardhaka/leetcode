package com.javatesting.linkedlist;

public class LinkedList {

    private Node header;

    public void addAtStart(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.header);
        this.header = newNode;
    }
}
