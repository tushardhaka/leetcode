package com.javatesting;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String [] args){
        int[] input = {3,2,2,3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(input, val);
    }


    public int removeElement(int[] nums, int val) {

        int output=0;
        int j=nums.length-1;
        for(int i=0;i<=j;i++){
            if(nums[i]==val){
                while(j>i){
                    if(nums[j]!=val){
                        nums[i]=nums[j];
                        j--;
                        output++;
                        break;

                    }
                    j--;
                }
                if(nums[i]==val){
                    break;
                }
            }
            else{
                output++;
            }
        }
        System.out.println(output);
        System.out.println(Arrays.toString(nums));
        return output;

    }
}
