package com.javatesting;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

public class PartiontionBTree {

    public static void main(String[] args) {

        /*
        5
       / \
      10  10
      /\  / \
     1 2  2   3

         */

        BTreeNode bTreeNodeRoot = new BTreeNode(5);
        bTreeNodeRoot.setLeftNode(new BTreeNode(10));
        bTreeNodeRoot.setRightNode(new BTreeNode(10));


        Queue<BTreeNode> bTreeNodeQueue = new LinkedList<>();

    }

    private static void doPreOrderTraverseAndSum(BTreeNode rootNode, Queue<BTreeNode> bTreeNodeQueue){

        if(rootNode.getLeftNode()==null){
            rootNode.setLeftSum(0);

        }
        else {
            bTreeNodeQueue.add(rootNode.getLeftNode());
        }

        if(rootNode.getRightNode()!=null){
            bTreeNodeQueue.add(rootNode.getRightNode());
        }

        BTreeNode tempNode = bTreeNodeQueue.remove();

        doPreOrderTraverseAndSum(tempNode, bTreeNodeQueue);







        //doPreOrderTraverseAndSum(rootNode.getLeftNode());

    }

}
