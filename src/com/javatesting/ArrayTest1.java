package com.javatesting;

import java.util.Arrays;

public class ArrayTest1 {
    public static void main(String[] args) {
        ArrayTest1 arrayTest1 = new ArrayTest1();
        int [] input = new int[] {};
        int target = 0;

        int[] output = arrayTest1.searchRange(input, target);
        System.out.println(Arrays.toString(output));
    }

    public int[] searchRange(int[] nums, int target) {

        int[] output = new int[] {-1,-1};

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if(output[0]==-1){
                    output[0]=i;
                    output[1]=i;
                }
                else {
                    output[1]=i;
                }
            }
            if(nums[i]>target){
                break;
            }
        }
        return output;

    }
}
