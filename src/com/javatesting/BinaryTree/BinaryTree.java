package com.javatesting.BinaryTree;

public class BinaryTree {

    Node root;

    BinaryTree(int value){
        root = new Node(value);
    }
    BinaryTree(){
        root = null;
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(9);
        binaryTree.root.right = new Node(8);

        binaryTree.root.left.right = new Node(7);
        binaryTree.root.left.left = new Node(6);
        binaryTree.root.right.right = new Node(5);
        binaryTree.root.right.left = new Node(4);

        binaryTree.root.left.left.left = new Node(3);
        binaryTree.root.left.left.right = new Node(2);
        binaryTree.root.left.right.left = new Node(1);

        printBinaryTree(binaryTree.root);

    }
    public static void printBinaryTree(Node root){
        System.out.println(root.nodeValue);
        if(root.left!=null) {
            printBinaryTree(root.left);
        }
        if(root.right!=null) {
            printBinaryTree(root.right);
        }

    }
}
