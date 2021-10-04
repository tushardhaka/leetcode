package com.javatesting;

public class MaxSubarray {

    public static void main(String[] args) {
        MaxSubarray maxSubarray = new MaxSubarray();
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray.maxSubArray1(input));
    }



    public int maxSubArray1(int[] nums) {

        int count=0;
        int currentPointer=-1;

        for(int i=0;i<nums.length;i++){
            count = count + nums[i];
            if(i==0){
                currentPointer=0;
            }
            else{
                if(count<=0){
                    count = count - nums[currentPointer];
                    currentPointer++;
                }
            }


        }

        return count;

    }
}
