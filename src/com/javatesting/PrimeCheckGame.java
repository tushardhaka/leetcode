package com.javatesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeCheckGame {

    public static void main(String [] args){

        String SELECT_BASED_ON_NODE_ID_AND_ITEM_ID_WITH_LOCK = "SELECT * FROM  INV_SUPPLY WHERE NODE_ID = ? AND ITEM_ID = ? FOR UPDATE";

        System.out.println(String.format(SELECT_BASED_ON_NODE_ID_AND_ITEM_ID_WITH_LOCK, 10));



        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();
        String [] testInput = new String[testCount];
        scanner.nextLine();
        for(int i =0;i<testCount; i++){
            testInput[i]=scanner.nextLine();
        }



        for(int j =0;j<testCount; j++){
            String input = testInput[j];
            int low = Integer.parseInt(input.split(" ")[0]);
            int high = Integer.parseInt(input.split(" ")[1]);

            List<Integer> primeNumberList = new ArrayList<>() ;

            while (low <= high) {
                boolean flag = false;

                for(int i = 2; i <= low/2; ++i) {
                    // condition for nonprime number
                    if(low % i == 0) {
                        flag = true;
                        break;
                    }
                }

                if (!flag && low != 0 && low != 1)
                    primeNumberList.add(low);

                ++low;
            }
            if(primeNumberList.isEmpty()){
                System.out.println(-1);
            }
            else if (primeNumberList.size()==1){
                System.out.println(0);
            }
            else {
                System.out.println(primeNumberList.get(primeNumberList.size()-1) - primeNumberList.get(0));
            }

        }

    }
}
