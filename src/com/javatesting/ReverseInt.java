package com.javatesting;

public class ReverseInt {

    public static void main(String[] args) {
        ReverseInt reverseInt = new ReverseInt();

        System.out.println(reverseInt.isPalindrome("A man, a plan, a canal: Panama"));

    }


    public int reverse(int x) {

        int signBit = x>0?1:-1;

        String s = String.valueOf(x);
        int result=0;
        for(int i= s.length()-1;i>=0;i--){
            int tempChar = s.charAt(i);
            if(tempChar=='-'){
                break;
            }
            int temp = Character.getNumericValue(tempChar);
            int newNum = result*10;
            if(newNum/10!=result){
                return 0;
            }
            result = newNum+temp;

        }

        return signBit*result;

    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }

            if(s.charAt(i) != s.charAt(j)){
                System.out.println(s.charAt(i));
                System.out.println(s.charAt(j));
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

}


