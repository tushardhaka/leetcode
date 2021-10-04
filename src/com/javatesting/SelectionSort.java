package com.javatesting;

public class SelectionSort {

    public static void main (String[] args){
        int[] input = new int[]{4,3,2,1,7,10,6,5,2,3};
        printArray("Before", input);
        input = selectionSort(input);
        printArray("After", input);

    }
    static void printArray(String comment, int[] input){
        System.out.print(comment+" ");
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
    }

    static int[] selectionSort(int[] input){


        for(int j=0;j<input.length;j++) {
            int tempArrayValue = input[j];
            int tempArrayPosition = j;
            for (int i = j+1; i < input.length; i++) {
                if (input[i] < tempArrayValue) {
                    tempArrayValue = input[i];
                    tempArrayPosition = i;
                }
            }
            if(j!=tempArrayPosition){
                input[tempArrayPosition] = input[j];
                input[j]=tempArrayValue;
            }
        }


        return input;
    }
}
