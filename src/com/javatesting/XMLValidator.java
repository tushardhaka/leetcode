package com.javatesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class XMLValidator {

    public static void main(String[] args) {

        System.out.println(validate_xml("<></>"));

    }

    public static String validate_xml(String xml) {
        // Write your code here

        Stack<String> tagStack = new Stack<>();
        boolean isTagStarted = false;
        int i=0;
        while(i<xml.length()){

            if(xml.charAt(i)=='<'){
                if(isTagStarted){
                    return "parse error";
                }
                isTagStarted = true;

                if(i<xml.length()-1 && xml.charAt(i+1)=='/'){
                    i++;
                    int j=0;
                    while(true){
                        i++;
                        j++;
                        if(xml.charAt(i)=='<'){
                            return "parse error";
                        }
                        if(xml.charAt(i)=='>'){
                            isTagStarted=false;
                            break;
                        }
                        if(i==xml.length()-1){
                            break;
                        }
                    }
                    if(i>i-j+1){
                        String tempTag = tagStack.pop();
                        if(!xml.substring(i-j+1,i).equals(tempTag)) {
                            return "encountered closing tag without matching open tag for </"+xml.substring(i-j+1,i)+">";
                        }

                    }
                }
                else {
                    int j=0;
                    while(true){
                        i++;
                        j++;
                        if(xml.charAt(i)=='<'){
                            return "parse error";
                        }
                        if(xml.charAt(i)=='>'){
                            isTagStarted=false;
                            break;
                        }
                        if(i==xml.length()-1){
                            break;
                        }
                    }
                    if(i>i-j+1){
                        tagStack.push(xml.substring(i-j+1,i));
                    }
                }
            }
            else if(xml.charAt(i)=='>'){
                if(!isTagStarted){
                    return "parse error";
                }
            }

            i++;
        }

        if(tagStack.size()>0){
            return "missing closing tag for <"+tagStack.pop()+">";
        }
        if(isTagStarted){
            return "parse error";
        }

        return "valid";

    }
}
