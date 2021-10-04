package com.javatesting.BinaryTree;

public class NewNode {
    int nodeValue;
    NewNode leftNode;
    NewNode rightNode;

    public NewNode(int nodeValue){
        this.nodeValue = nodeValue;
    }

    public void setLeftNode(NewNode leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(NewNode rightNode){
        this.rightNode = rightNode;
    }

    public NewNode getLeftNode(){
        return this.leftNode;
    }

    public NewNode getRightNode(){
        return this.rightNode;
    }

    public int getNodeValue(){
        return this.nodeValue;
    }
}
