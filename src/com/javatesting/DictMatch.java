package com.javatesting;

import java.util.Arrays;
import java.util.List;

public class DictMatch {
    /*
Example 1:

Input: s = "hihello", wordDict = ["hi","hello"]
Output: true

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false



     */


    public static void main(String[] args) {

        List<String> input = Arrays.asList("hi","hello");
        System.out.println(matchAgainstDict("hihello", input));


    }

    private static boolean matchAgainstDict(String input, List<String> dictWords){

        boolean outcome = false;
        for(int i=0;i<input.length();i++){
            String tempString = input.substring(0,i);
            if(dictWords.contains(tempString)) {
                System.out.println(tempString);
                if(matchAgainstDict(input.substring(i,input.length()), dictWords)){
                    outcome = true;
                    break;
                }
            }
        }

        return outcome;

    }

}
