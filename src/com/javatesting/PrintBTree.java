package com.javatesting;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class PrintBTree {
    public static void main(String[] args) {

        PrintBTree printBTree = new PrintBTree();
        printBTree.printTree(printBTree.prepareTree2());
    }

    public TreeNode prepareTree1(){
        TreeNode node = new TreeNode(4);

        TreeNode node1 = new TreeNode(2, null, node);

        TreeNode node2 = new TreeNode(3, null, null);

        TreeNode rootNode = new TreeNode(1, node1, node2);

        return rootNode;
    }

    public TreeNode prepareTree2(){
        TreeNode node = new TreeNode(4);

        TreeNode node1 = new TreeNode(3, node, null);

        TreeNode node2 = new TreeNode(2, node1, null);

        TreeNode node3 = new TreeNode(5);

        TreeNode rootNode = new TreeNode(1, node2, node3);

        return rootNode;
    }

    public List<List<String>> printTree(TreeNode root) {

        int treeHeight = maxDepth(root);
        int maxNumOfNodes = (int)Math.pow(2, treeHeight) - 1 ;

        List<List<String>> output = new ArrayList<>();

        for(int i=0;i<treeHeight;i++){
            List<String> tempList = new ArrayList<>();
            for(int j=0;j<maxNumOfNodes;j++){
                tempList.add("\"\"");
            }
            output.add(tempList);
        }

        traverseBT(root, treeHeight, 1 ,((int)Math.pow(2, treeHeight))/2, output);



        return output;
    }

    public void traverseBT(TreeNode rootNode,int totalHeight, int currentHeight, int startPosition,
                           List<List<String>> output){
        if(rootNode==null){
            return;
        }

        output.get(currentHeight-1).set(startPosition-1, String.valueOf(rootNode.val));
        int temp = ((int)Math.pow(2, totalHeight - currentHeight))/2;


        traverseBT(rootNode.left,totalHeight, currentHeight+1, startPosition - temp, output);
        traverseBT(rootNode.right,totalHeight, currentHeight+1, startPosition + temp, output);
    }

    int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

}
