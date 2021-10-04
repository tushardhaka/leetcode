package com.javatesting;

import java.util.Arrays;

public class ArrayTwoNumberSum {

    public static void main(String[] args) {
        int input[] = new int[] {3, 7, 1, 2, 8, 4, 5};

        int targetSum = 4;
        System.out.println(Arrays.toString(twoSum(input, targetSum)));

    }
    public static int[] twoSum(int[] nums, int target) {
        int output[] = new int[2];
        boolean found=false;

        for(int i=0;i< nums.length;i++){
            int firstNumber = nums[i];
            for(int j=i+1;j<nums.length;j++){

                if(nums[i]+nums[j]==target){
                    output[0]=i+1;
                    output[1]=j+1;
                    found=true;
                    break;
                }
            }
            if(found)
                break;
        }

        return output;
    }
}
