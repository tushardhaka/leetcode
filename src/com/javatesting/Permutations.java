package com.javatesting;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{0,-1,1});
    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        //permuteRec(nums, new ArrayList<>(), new ArrayList<>(), result);
        permuteItr(nums, result);
        return result;

    }

    public void permuteItr(int[] inputNums, List<List<Integer>> result){
        Queue<List<Integer>> queue = new LinkedList<>();

        for(int i : inputNums){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            queue.add(list);
        }
        while(!queue.isEmpty()){
            List<Integer> current = queue.remove();
            if(current.size()==inputNums.length){
                result.add(current);
            }else {
                for (int i = 0; i < inputNums.length; i++) {
                    if (!current.contains(inputNums[i])) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.addAll(current);
                        tempList.add(inputNums[i]);
                        queue.add(tempList);
                    }
                }
            }
        }
    }

    public void permuteRec(int[] inputNums, List<Integer> alreadyProcessedIndex,List<Integer> currentCombination,
                           List<List<Integer>> result){

        if(currentCombination.size()==inputNums.length){
            result.add(currentCombination);
            return;
        }

        for(int i=0;i<inputNums.length;i++){
            if(!alreadyProcessedIndex.contains(i)){
                alreadyProcessedIndex.add(i);
                currentCombination.add(inputNums[i]);
                permuteRec(inputNums, alreadyProcessedIndex, currentCombination, result);
            }
        }

    }
}
