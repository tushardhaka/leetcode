package com.javatesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundPricesToMatchTarget {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(-4,3,-9,0,4,1);

        plusMinus(input);

    }


    public static void plusMinus(List<Integer> arr) {



        // Write your code here
        int postiveNumbers=0;
        int negativeNumbers=0;
        int zeroNumbers=0;

        for(int i : arr){
            if(i>0){
                postiveNumbers++;
            }
            if(i<0){
                negativeNumbers++;
            }
            if(i==0){
                zeroNumbers++;
            }
        }

        System.out.println(String.format("%.6f", ((float)postiveNumbers)/arr.size()) );
        System.out.println(String.format("%.6f", ((float)negativeNumbers)/arr.size()) );
        System.out.println(String.format("%.6f", ((float)zeroNumbers)/arr.size()) );


    }


    // Complete the roundPricesToMatchTarget function below.
    static List<Integer> roundPricesToMatchTarget(List<Float> prices, int target) {



        return null;
    }

    static void findRoundedNumbers(List<Float> prices, int target, Float roundOffSum, List<Integer> output){
        System.out.println(prices);

        if(prices.size()==1){
            if(target>prices.get(0)){
                output.add(target);
                roundOffSum = roundOffSum+(target-prices.get(0));
            }
            else {
                output.add(target);
                roundOffSum = roundOffSum+(prices.get(0)-target);
            }

        }
        else {

            Float currentNum = prices.get(0);
            int ceilNumber = (int)Math.ceil(currentNum);
            int floorNumber = (int)Math.floor(currentNum);
            prices.remove(0);

            List<Integer> outputWithCeil = new ArrayList<>(output);
            outputWithCeil.add(ceilNumber);
            List<Integer> outputWithFloor = new ArrayList<>(output);
            outputWithFloor.add(floorNumber);
            findRoundedNumbers(prices, target - ceilNumber, roundOffSum+(ceilNumber-currentNum), outputWithCeil);
            findRoundedNumbers(prices, target - floorNumber, roundOffSum+(currentNum-floorNumber), outputWithFloor);

        }

    }

}
