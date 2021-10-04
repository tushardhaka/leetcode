package com.javatesting;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        int[] input = {0,0,0};
        threeSum.threeSumNew(input);
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> tempSet = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int target = 0-nums[i];
            Set<Integer> inputSet = new HashSet<>();
            for(int j=i+1;j<nums.length ;j++){
                int currentNum = nums[j];
                if(inputSet.contains(target-currentNum)){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(currentNum);
                    tempList.add(target-currentNum);
                    Collections.sort(tempList);
                    if(!tempSet.contains(tempList)){
                        System.out.println(tempList.toString());
                        result.add(tempList);
                        tempSet.add(tempList);
                    }



                }
                else {
                    inputSet.add(currentNum);
                }
            }
        }

        return result;

    }


    public List<List<Integer>> threeSumNew(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;

            while(j<=k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    //skipping condition for j and k
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(k>j && nums[k]==nums[k+1])
                        k--;
                }else{
                    if(sum>0){
                        k--;
                    }
                    else{
                        j++;
                    }
                }

            }


        }


    return result;

    }
}
