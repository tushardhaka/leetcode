package com.javatesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBSTRootNode {

    public static void main(String[] args) {

        FindBSTRootNode findBSTRootNode = new FindBSTRootNode();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(17,-1,-1));
        input.add(Arrays.asList(15, 13, 17));
        input.add(Arrays.asList(7, -1, -1));
        input.add(Arrays.asList(13, -1, -1));
        input.add(Arrays.asList(5, 3, 7));
        input.add(Arrays.asList(3, -1, -1));
        input.add(Arrays.asList(10, 5, 15));
        System.out.println(findBSTRootNode.findRoot(input));

    }

    public int findRoot(List<List<Integer>> nodes) {
        // Write your code here

        class BSTNode {
            public int value;
            public BSTNode left;
            public BSTNode right;

            public BSTNode(int value, BSTNode left, BSTNode right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }


        }

        List<BSTNode> bstNodeList = new ArrayList<>();
        for(List<Integer> integerList : nodes){
            BSTNode leafNode = new BSTNode(integerList.get(0), null, null);
            bstNodeList.add(leafNode);
        }


        for(List<Integer> integerList : nodes){

            if(!(integerList.get(1)==-1 && integerList.get(2)==-1)){

                for(BSTNode bstNode : bstNodeList){
                    if(integerList.get(0)== bstNode.value){
                        for(BSTNode bstNode1 : bstNodeList){
                            if(integerList.get(1)== bstNode1.value){
                                bstNode.left = bstNode1;
                            }
                            if(integerList.get(2)== bstNode1.value){
                                bstNode.right = bstNode1;
                            }
                        }
                    }
                }

            }
        }
        return -1;

    }




}
