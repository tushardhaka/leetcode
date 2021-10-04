package com.javatesting;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        String[] input = {"eat","tea","tan","ate","nat","bat"};

        groupAnagrams.groupAnagramsNew(input);
    }

    public List<List<String>> groupAnagramsNew(String[] strs) {

        Map<String, List<String>> output = new HashMap<>();

        List<List<String>> result = new ArrayList<>();

        for(String s : strs){
            char[] stringArray = s.toCharArray();
            Arrays.sort(stringArray);

            String temp = Arrays.toString(stringArray);

            if(output.containsKey(temp)){
                List<String> current = output.get(temp);
                current.add(s);
                output.put(temp, current);
            }
            else {
                output.put(temp, new ArrayList<String>(Arrays.asList(s)));
            }

        }


        for(List<String> temp : output.values()){
            result.add(temp);

        }


        return result;

    }

    public List<List<String>> groupAnagrams(String[] strs) {



        Map<String, List<String>> output = new HashMap<>();

        for(String s : strs){

            int[] alphabetArray = new int[26];

            for(char c : s.toCharArray()){
                alphabetArray[Character.getNumericValue(c)-10]++;
            }
            StringBuilder sb = new StringBuilder("-");
            for(int i : alphabetArray){
                sb.append(i).append("-");
            }

            System.out.println(sb.toString());

            if(output.containsKey(sb.toString())){
                List<String> current = output.get(sb.toString());
                current.add(s);
                output.put(sb.toString(), current);
            }
            else {
                output.put(sb.toString(), new ArrayList<String>(Arrays.asList(s)));
            }

        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> temp : output.values()){
            result.add(temp);
        }


        return result;

    }
}
