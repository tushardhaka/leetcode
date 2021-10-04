package com.javatesting;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {

        if(s.length()==0 || s.length()==1){
            return 0;
        }
        int counter = 0;
        int finalCounter = 0;

        char currentChar=' ';
        char previousChar=' ';
        for(int i = 0;i<s.length();i++) {
            currentChar = s.charAt(i);
            if (previousChar == ' ' && currentChar == '(') {
                counter++;
                previousChar = currentChar;
                continue;
            }
            if (previousChar == ' ' && currentChar == ')') {
                previousChar = currentChar;
                continue;
            }
            if (previousChar == '(' && currentChar == ')') {
                counter++;
                previousChar = currentChar;
                continue;
            }

            if (previousChar == '(' && currentChar == '(') {
                counter++;
                previousChar = currentChar;
                continue;
            }

            if (previousChar == ')' && currentChar == ')') {
                counter++;
                previousChar = currentChar;
                continue;
            }

            if (previousChar == ')' && currentChar == '(') {
                counter++;
                previousChar = currentChar;
                continue;
            }

            if (previousChar == '(' && currentChar == ')') {
                counter++;
                previousChar = currentChar;
                continue;
            }
        }
        return counter;
    }

}
