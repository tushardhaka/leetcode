package com.javatesting;

import java.util.HashMap;
import java.util.Map;

public class RomandToInt {

    public static void main(String [] args){
        String input = "III";
        RomandToInt romandToInt = new RomandToInt();
        //System.out.println(romandToInt.romanToInt(input));


    }

    public void romanToInt(String s) {

        Map<String, Integer> romanNumberMap = new HashMap<String, Integer>();
        romanNumberMap.put("I",1);
        romanNumberMap.put("V",5);
        romanNumberMap.put("X",10);
        romanNumberMap.put("L",50);
        romanNumberMap.put("C",100);
        romanNumberMap.put("D",500);
        romanNumberMap.put("M",1000);


    }
}
