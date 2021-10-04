package com.javatesting;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] input = {0,1,0,3,12};
        moveZeros.moveZeroes(input);
    }


    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }

        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                counter=i;
                counter++;
                while(counter<nums.length){
                    if(nums[counter]!=0){
                        nums[i]=nums[counter];
                        nums[counter]=0;
                        break;
                    }
                    counter++;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

    }
}
