package com.javatesting;

public class NumberReverse {
    public static void main(String [] args){
        NumberReverse numberReverse = new NumberReverse();
        int input = 1230;
        System.out.println(numberReverse.reverse(input));
    }



    public int reverse(int x) {

        boolean negativeNumber=false;
        if(x<0){
            x=x*-1;
            negativeNumber=true;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        boolean firstRun = true;

        while(true){
            if(firstRun && x%10>0){
                stringBuffer.append(x%10);
            }
            else {
                stringBuffer.append(x%10);
            }
            x=(x-x%10)/10;
            firstRun = false;
            if(x==0)
                break;
        }
        int output = Integer.parseInt(stringBuffer.toString());
        if(negativeNumber){
            return output*-1;
        }
        else {
            return output;
        }

    }
}
