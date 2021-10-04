package com.javatesting;

import java.util.*;

public class SearchIn2DSortedArray {

    public static void main(String[] args){
        SearchIn2DSortedArray searchIn2DSortedArray = new SearchIn2DSortedArray();
        int[][] input = {{1,2,3,4}};
        int target = 2;

        //System.out.println(searchIn2DSortedArray.searchMatrix(input, target));

        int[] nums = {1,2,3,4};
        Set<Integer> set = new HashSet(Arrays.asList(nums));

        System.out.println(nums.length);
        System.out.println(set.size());
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){

            }
        }
        System.out.println(nums.length != set.size());
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0;
        int j=matrix[0].length-1;
        while(true){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                j--;
            }
            else if(matrix[i][j]<target){
                i++;
            }

            if(j<0 || i>matrix.length-1){
                break;
            }

        }
        return false;

    }
}
