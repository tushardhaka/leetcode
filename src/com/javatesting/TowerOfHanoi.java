package com.javatesting;

public class TowerOfHanoi {

    public static void main(String[] args){

        toh(100, 'A', 'C','B');
    }

    public static void toh(int n, char tower1, char tower2, char tower3){
        if(n==1){
            System.out.println("Ring "+n+" from tower "+tower1+" -> tower "+tower2);
            return;
        }
        toh(n-1, tower1, tower3, tower2);
        System.out.println("Ring "+n+" from tower "+tower1+" -> tower "+tower2);
        toh(n-1, tower3, tower2, tower1);

    }
}
