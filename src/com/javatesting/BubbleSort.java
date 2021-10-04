package com.javatesting;

import java.util.Arrays;

public class BubbleSort {

    public static void main (String[] args){
        int[] input = new int[]{4,3,2,1,7,10,6,5,2,3};
        System.out.println("Before " + Arrays.toString(input));
        input = bubbleSort(input);
        System.out.println("After " + Arrays.toString(input));

    }
    static int[] bubbleSort(int[] input){
        for(int j=0;j<input.length;j++) {
            for (int i = 0; i < input.length - 1; i++) {
                int temp;
                if (input[i + 1] < input[i]) {
                    temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }

            }
        }
        return input;

    }
}
