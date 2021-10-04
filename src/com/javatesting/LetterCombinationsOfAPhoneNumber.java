package com.javatesting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "";

        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(digits));
    }


    public List<String> letterCombinations(String digits) {

        String[] charAgainstNumber = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };


        List<String> result = new ArrayList<>();

        //letterCombinationsRec(digits, "", 0, charAgainstNumber, result);

        letterCombinationItr(digits, charAgainstNumber, result);

        return result;
    }

    public void letterCombinationItr(String digits, String[] charAgainstNumber, List<String> result){
        Queue<String> queue = new LinkedList<>();

        queue.add("");

        while(!queue.isEmpty()){

            String currentString = queue.remove();

            if(currentString.length()==digits.length()){
                if(currentString!="") {
                    result.add(currentString);
                }
                continue;
            }

            String tempString = charAgainstNumber[digits.charAt(currentString.length()) - '0'];


            for(char c : tempString.toCharArray()){
                queue.add(currentString+c);
            }

        }
    }

    public void letterCombinationsRec(String digits, String currentString, int index, String[] charAgainstNumber, List<String> result){

        if(currentString.length()==digits.length()){
            if(currentString!="") {
                result.add(currentString);
            }
            return;
        }

        String tempString = charAgainstNumber[digits.charAt(index) - '0'];

        index++;
        for(char c : tempString.toCharArray()){
            letterCombinationsRec(digits, currentString+c, index, charAgainstNumber, result);
        }




    }
}
