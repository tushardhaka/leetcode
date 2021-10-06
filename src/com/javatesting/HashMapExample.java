package com.javatesting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapExample {

    public static void main(String[] args) {

        Map<Integer, Integer> testMap = new HashMap<>();

        testMap.put(1,1);
        testMap.put(2,2);
        testMap.put(3,3);
        testMap.put(4,4);
        testMap.put(5,5);

        for(Map.Entry<Integer, Integer> entry : testMap.entrySet()) {
            //System.out.println(entry.getKey()+" "+entry.getValue());
        }

        for(int i : testMap.values()){
            //System.out.println(i);
        }
        for(int i : testMap.keySet()){
            //System.out.println(i);
        }



        Iterator<Map.Entry<Integer, Integer>> iterator =  testMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            //System.out.println(entry.getKey()+" "+entry.getValue());
            //iterator.remove();
        }

        //testMap.forEach((k,v) -> System.out.println(k+" "+v));

        //testMap.entrySet().stream().forEach(k -> System.out.println(k.getKey()+" "+k.getValue()));
        testMap.entrySet().stream().filter(k -> k.getKey()==1).forEach(k -> System.out.println(k.getKey()+" "+k.getValue()));

        List<Integer> testList1 = testMap.entrySet().stream()
                .filter(k -> k.getKey()%2==0)
                .map(k -> k.getKey())
                .collect(Collectors.toList());

        System.out.println(testList1.stream().mapToInt(x -> x).findFirst());
        System.out.println(Arrays.asList(testList1).toString() );

        List<String> testList = Arrays.asList("Tushar","Dhaka","Sheetal");

        System.out.println(testList.stream().filter(x -> !x.startsWith("D")).collect(Collectors.joining(",")));






    }
}
