package com.javatesting;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
        System.out.println(stringToIntegerAtoi.myAtoi("-91283472332"));
    }


    public int myAtoi(String s) {

        String newString = s.trim();
        if(newString=="" || newString.length()==0){
            return 0;
        }
        char currentChar = newString.charAt(0);

        int signBit = currentChar=='-'?-1:1;
        int currentIndex = currentChar=='-' || currentChar=='+' ? 1:0;

        char[] stringCharArr = newString.toCharArray();
        long result=0;
        for(int i=currentIndex;i<stringCharArr.length;i++){
            if(Character.isDigit(stringCharArr[i])){
                result = result*10+Character.getNumericValue(stringCharArr[i]);

                if(result>Integer.MAX_VALUE)
                    return signBit==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                else if(result<Integer.MIN_VALUE)
                    return signBit==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            else {
                return signBit*(int)result;
            }
        }

        return signBit*(int)result;

    }
}
