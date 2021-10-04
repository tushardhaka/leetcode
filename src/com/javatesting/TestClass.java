package com.javatesting;

/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.*;
import java.util.*;

import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] ss = br.readLine().trim().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
        String[] arr_Amount = br.readLine().split(" ");
        int[] Amount = new int[N];
        for (int i_Amount = 0; i_Amount < arr_Amount.length; i_Amount++) {
            Amount[i_Amount] = Integer.parseInt(arr_Amount[i_Amount]);
        }

        long out_ = magicLand(Amount, M, N);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static long magicLand(int[] Amount, int M, int N) {
        // Write your code here

        return 0;
    }
}
