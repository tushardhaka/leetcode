package com.javatesting.BinaryTree;

public class Node {

    int nodeValue;
    Node left, right;

    Node(int value){
        this.nodeValue = value;
        left = right = null;
    }

    public void insert(int value){
        if (value<=nodeValue){
            if(left==null){
                left = new Node(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if(right==null){
                right = new Node(value);
            }
            else {
                right.insert(value);
            }
        }

    }

    public boolean contains(int value){
        if(nodeValue == value){
            return true;
        }
        else if(value<nodeValue){
            if (left == null){
                return false;
            }
            else {
                return left.contains(value);
            }
        }
        else {
            if (right == null){
                return false;
            }
            else {
                return right.contains(value);
            }
        }
    }
    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        System.out.println(nodeValue);
        if(right != null){
            right.printInOrder();
        }
    }

    public void findUnivalTree(){
        System.out.println(findUnivalTreeRec(this, 0));
    }

    public int findUnivalTreeRec(Node node, int counter){
        if(node.left==null && node.right == null){
            return counter++;
        }
        if(node.nodeValue== node.left.nodeValue && node.nodeValue == node.right.nodeValue){
            return counter++;
        }
        findUnivalTreeRec(node.left, counter);
        findUnivalTreeRec(node.right, counter);

        return 1;
    }
}
