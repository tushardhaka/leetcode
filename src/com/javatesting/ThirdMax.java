package com.javatesting;

public class ThirdMax {
    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        int[] input = {1,2,-2147483648};
        System.out.println(thirdMax.thirdMax(input));
    }

    public int thirdMax(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
                temp++;

            } else if (nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
                temp++;
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
                temp++;
            }

        }

        if(temp<nums.length){
            return firstMax;
        }
        return thirdMax;
    }

}
