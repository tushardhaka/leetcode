package com.javatesting;

import java.util.Scanner;

public class FibDp {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int iNum = scanner.nextInt();

        FibDp fibDp = new FibDp();
        System.out.println(fibDp.fibRec(iNum));

    }

    public int fibDP(int i){
        return 0;
    }

    public int fibRec(int i){
        if(i==1 || i==2)
            return 1;
        else
            return fibRec(i-1)+fibRec(i-2);
    }
}
