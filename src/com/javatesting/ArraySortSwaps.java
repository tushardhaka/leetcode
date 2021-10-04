package com.javatesting;

import java.util.Arrays;
import java.util.List;

public class ArraySortSwaps {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 1, 3, 1, 2);

        System.out.println(countInversions(input));
    }

    public static long countInversions(List<Integer> arr) {
        // Write your code here

        long swapCount = 0;
        if(arr.size()==1){
            return swapCount;
        }

        Integer iPrevious = null;
        for(int i=0;i<arr.size();i++){
            if(iPrevious==null){
                iPrevious = arr.get(i);
                continue;
            }
            else {
                if(arr.get(i)>=iPrevious){
                    iPrevious = arr.get(i);
                    continue;
                }
                else {
                    int currentI = i;
                    for(int j = currentI-1;j>=0;j--){
                        if(arr.get(j)>arr.get(currentI)){
                            swapCount++;

                            int tempI = arr.get(currentI);
                            int tempJ = arr.get(j);
                            arr.set(j, tempI);
                            arr.set(currentI, tempJ);
                            currentI--;
                        }
                    }
                }

            }
        }
        return swapCount;
    }
}
