package com.javatesting;

public class InsertionSort {

    public static void main (String[] args){
        int[] input = new int[]{4,3,2,1,7,10,6,5,2,3};
        printArray("Before", input);
        input = insertionSort(input);
        printArray("After", input);

    }
    static void printArray(String comment, int[] input){
        System.out.print(comment+" ");
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
    }

    static int[] insertionSort(int[] input){
        for(int i=0;i<input.length;i++){
            for(int j=i;j>0;j--){
                if(input[j]>input[j-1]){
                    break;
                }
                int temp=input[j];
                input[j]=input[j-1];
                input[j-1]=temp;
            }
        }
        return input;
    }
}
