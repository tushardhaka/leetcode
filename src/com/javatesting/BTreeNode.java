package com.javatesting;

public class BTreeNode {

    private int nodeValue;
    private BTreeNode leftNode;
    private BTreeNode rightNode;
    private  int leftSum;
    private  int rightSum;

    BTreeNode(int nodeValue){
        this.nodeValue = nodeValue;
        leftNode = null;
        rightNode = null;
    }

    public BTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getLeftSum() {
        return leftSum;
    }

    public void setLeftSum(int leftSum) {
        this.leftSum = leftSum;
    }

    public int getRightSum() {
        return rightSum;
    }

    public void setRightSum(int rightSum) {
        this.rightSum = rightSum;
    }
}
