package com.javatesting.BinaryTree;

import java.util.*;

public class NewBT {

    public static void main(String[] args) {
        /*
                    0
                   / \
                  /   \
                 1     2
                /\    /\
               3  4  5  6
                \        \
                 8        7
                /
               9
         */


        NewNode rootNode = new NewNode(0);
        NewNode node1 = new NewNode(1);
        NewNode node2 = new NewNode(2);
        NewNode node3 = new NewNode(3);
        NewNode node4 = new NewNode(4);
        NewNode node5 = new NewNode(5);
        NewNode node6 = new NewNode(6);
        NewNode node7 = new NewNode(7);
        NewNode node8 = new NewNode(8);
        NewNode node9 = new NewNode(9);

        rootNode.setLeftNode(node1);
        rootNode.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);

        node2.setLeftNode(node5);
        node2.setRightNode(node6);
        node6.setRightNode(node7);

        node3.setRightNode(node8);
        node8.setLeftNode(node9);


        NewBT newBT = new NewBT();
        //newBT.inorderTravelRec(rootNode);
        //System.out.println();
        //

        //System.out.println();
        //newBT.preorderTravelRec(rootNode);
        //newBT.levelOrderTravel(rootNode);

        //newBT.reverselevelOrderTravel(rootNode);
        //System.out.println("Height of BT = "+newBT.findHeight(rootNode));
        //System.out.println("Diameter of BT = "+newBT.btDiameter(rootNode));

        //newBT.createMirror(rootNode);
        //newBT.inorderTravelIte(rootNode);

        //newBT.levelOrderTravelRec(rootNode, 0);
        //System.out.println("---------------------------------");
        //newBT.levelOrderTravelIte(rootNode);

        //[4,2,6,1,3]
        //[27,null,34,null,58,50,null,44]
        /*
                    27
                     \
                      34
                       \
                       58
                       /
                     50
                    /
                  44
         */

        TreeNode treeNode44 = new TreeNode(44, null, null);
        TreeNode treeNode50 = new TreeNode(50, treeNode44, null);
        TreeNode treeNode58 = new TreeNode(58, treeNode50, null);
        TreeNode treeNode34 = new TreeNode(34, null, treeNode58);
        TreeNode treeNode27 = new TreeNode(27, null, treeNode34);

        System.out.println(newBT.minDiffInBST(treeNode27));
    }

    public void inorderTravelRec(NewNode node){


        if(node.getLeftNode()!=null){
            inorderTravelRec(node.getLeftNode());
        }

        System.out.print(node.getNodeValue()+" ");

        if(node.getRightNode()!=null){
            inorderTravelRec(node.getRightNode());
        }

    }

    public void inorderTravelIte(NewNode node){

        Stack<NewNode> newNodeStack = new Stack<>();

        //System.out.println(node.getNodeValue());

        NewNode currentNode = node;
        while(!newNodeStack.empty() || currentNode != null){

            if (currentNode != null)
            {
                newNodeStack.push(currentNode);
                currentNode = currentNode.leftNode;
            }
            else {
                currentNode = newNodeStack.pop();
                System.out.print(currentNode.nodeValue + " ");

                currentNode = currentNode.rightNode;
            }

        }
    }



    public void preorderTravelRec(NewNode node){

        System.out.print(node.getNodeValue()+" ");

        if(node.getLeftNode()!=null){
            preorderTravelRec(node.getLeftNode());
        }



        if(node.getRightNode()!=null){
            preorderTravelRec(node.getRightNode());
        }

    }


    public void levelOrderTravel(NewNode node){

        Queue<NewNode> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){
            NewNode currentNode = queue.poll();
            System.out.print(currentNode.nodeValue+" ");
            if(currentNode.leftNode!=null){
                queue.add(currentNode.leftNode);
            }
            if(currentNode.rightNode!=null){
                queue.add(currentNode.rightNode);
            }

        }
    }

    public void reverselevelOrderTravel(NewNode node){

        Queue<NewNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(node);

        while(!queue.isEmpty()){
            NewNode currentNode = queue.poll();
            stack.push(currentNode.nodeValue);

            if(currentNode.rightNode!=null){
                queue.add(currentNode.rightNode);
            }

            if(currentNode.leftNode!=null){
                queue.add(currentNode.leftNode);
            }


        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }


    public int findHeight(NewNode node){


        if(node==null)
            return 0;
        int leftHeight = findHeight(node.leftNode);
        int rightHeight = findHeight(node.rightNode);
        maxDiameter = Math.max(maxDiameter, leftHeight+rightHeight+1);
        int height = 1+ Math.max(leftHeight, rightHeight);

        return height;
    }


    int maxDiameter;
    public int btDiameter(NewNode node){
        findHeight(node);

        return maxDiameter;
    }

    public void createMirror(NewNode rootnode){
        Stack<NewNode> newNodeList = new Stack<>();
        newNodeList.push(rootnode);
        while(!newNodeList.isEmpty()){
            NewNode node = newNodeList.pop();
            if(node.leftNode!=null){
                newNodeList.push(node.leftNode);
            }
            if(node.rightNode!=null){
                newNodeList.push(node.rightNode);
            }


            swapChild(node);
        }

    }

    public void swapChild(NewNode node){
        NewNode leftChild = node.leftNode;
        NewNode rightChild = node.rightNode;
        node.setLeftNode(rightChild);
        node.setRightNode(leftChild);
    }


    public void levelOrderTravelRec(NewNode node, int level){
        if(node==null){
            return;
        }

        System.out.println("Level - "+level+" NodeValue - "+ node.nodeValue);

        levelOrderTravelRec(node.leftNode, level+1);
        levelOrderTravelRec(node.rightNode, level+1);


    }
    public void levelOrderTravelIte(NewNode node){


        if(node==null){
            return;
        }
        Queue<NewNode> queue = new LinkedList<>();

        queue.add(node);

        int levelCounter = 1;
        while(!queue.isEmpty()){

            System.out.print("Level "+levelCounter+" -->");
            int currentQueueSize = queue.size();
            for(int i=0;i<currentQueueSize;i++){
                NewNode currentNode = queue.remove();
                if(currentNode==null){
                    continue;
                }
                System.out.print(" "+currentNode.nodeValue);
                queue.add(currentNode.leftNode);
                queue.add(currentNode.rightNode);
            }
            System.out.println();
            levelCounter++;
        }

    }


    public int minDiffInBST(TreeNode root) {

        List<Integer> inputList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        TreeNode currentNode = root;
        while(!stack.empty()){
            if(currentNode.left!=null){
                stack.push(currentNode.left);
                currentNode = currentNode.left;
                continue;
            }
            currentNode = stack.pop();
            inputList.add(currentNode.val);

            if(currentNode.right!=null){
                stack.push(currentNode.right);
                currentNode = currentNode.right;
            }
        }

        System.out.println(inputList);

        int minDiff = inputList.get(1)-inputList.get(0);
        for(int i=1;i<inputList.size()-1;i++){

            if(minDiff> inputList.get(i+1)-inputList.get(i)){
                minDiff = inputList.get(i+1)-inputList.get(i);
            }
        }
        return minDiff;

    }

}
