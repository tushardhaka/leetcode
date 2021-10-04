package com.javatesting;

import java.util.Scanner;

public class PatternMatching {

    public static void main(String [] args){
        //Scanner scanner = new Scanner(System.in);

        //String input = scanner.next();
        //String pattern = scanner.next();

        //PatternMatching patternMatching = new PatternMatching();

        //System.out.println(patternMatching.isMatch(input, pattern));


        System.out.println("FB".hashCode());
        System.out.println("Ea".hashCode());
    }

    public boolean isMatch(String s, String p) {

        boolean match = true;
        char currentChar=' ';
        char previousChar=' ';
        int starCounter=0;
        int inputStringTraversed=0;
        for(int i=0;i<p.length();i++){
            currentChar = p.charAt(i);
            if(p.charAt(i)=='*' ){
                if(previousChar==' '){
                    match=false;
                    break;
                }
                if(previousChar=='.' ){
                    inputStringTraversed++;
                    continue;
                }
                if(previousChar==s.charAt(i)){
                    inputStringTraversed++;
                    continue;
                }
                if(previousChar!=s.charAt(i)){
                    previousChar=' ';
                    continue;
                }
            }
            if(p.charAt(i)=='.' ){
                previousChar=currentChar;
                inputStringTraversed++;
                continue;
            }
            if(currentChar == s.charAt(i)) {
                previousChar=currentChar;
                inputStringTraversed++;
                continue;
            }
            if(p.charAt(i) != s.charAt(i)) {
                if(i<p.length() && p.charAt(i+1)=='*'){
                    i++;
                    continue;
                }
                match = false;
                break;
            }

        }

        if(match){
            if(inputStringTraversed!=s.length())
                match=false;
        }

        return match;
    }
}
