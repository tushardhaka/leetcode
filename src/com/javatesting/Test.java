package com.javatesting;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9, l1);
        ListNode l3 = new ListNode(9, l2);
        ListNode l4 = new ListNode(9, l3);


        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9, m1);
        ListNode m3 = new ListNode(9, m2);
        ListNode m4 = new ListNode(9, m3);
        ListNode m5 = new ListNode(9, m4);
        ListNode m6 = new ListNode(9, m5);
        ListNode m7 = new ListNode(9, m6);

        Test test = new Test();
        //test.print(test.addTwoNumbers(m7, l4));

        //System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        int[] array1 = new int[]{1,3};
        int[] array2 = new int[]{2};
        System.out.println(test.findMedianSortedArrays(array1, array2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arrayNew = new int[nums1.length+nums2.length];
        int array1Counter=0;
        int array2Counter=0;
        int arrayNewCounter = 0;
        do{
            if(nums1[array1Counter]>nums2[array2Counter]){
                arrayNew[arrayNewCounter]=nums2[array2Counter];
                array2Counter++;
            }
            if(nums1[array1Counter]<nums2[array2Counter]){
                arrayNew[arrayNewCounter]=nums1[array1Counter];
                array1Counter++;
            }
            if(nums1[array1Counter]==nums2[array2Counter]){
                arrayNew[arrayNewCounter]=nums1[array1Counter];
                array1Counter++;
                array2Counter++;
            }

            arrayNewCounter++;
        }while(true);

    }


    public void print(ListNode l1){

        List<Integer> listOfNumbers = new ArrayList<Integer>();
        ListNode temp = l1;

        do{
            listOfNumbers.add(temp.val);
            temp=temp.next;
        }while(temp!=null);

        System.out.println(listOfNumbers);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        ListNode temp = l1;

        do{
            listOfNumbers.add(temp.val);
            temp=temp.next;
        }while(temp!=null);

        temp = l2;
        List<Integer> listOfNumbers1 = new ArrayList<Integer>();
        do{
            listOfNumbers1.add(temp.val);
            temp=temp.next;
        }while(temp!=null);

        int maxLength = listOfNumbers.size()>=listOfNumbers1.size()?listOfNumbers.size():listOfNumbers1.size();

        int carryFwd=0;
        List<Integer> outcome = new ArrayList<Integer>();
        for(int i=0;i<maxLength;i++){
            int num1 = listOfNumbers.size()>i?listOfNumbers.get(i):0;
            int num2 = listOfNumbers1.size()>i?listOfNumbers1.get(i):0;
            int sum = num1+num2+carryFwd;
            if(sum>=10) {
                outcome.add(sum % 10);
                carryFwd = sum / 10;
            }
            else {
                carryFwd=0;
                outcome.add(sum);
            }

        }
        if(carryFwd!=0){
            outcome.add(carryFwd);
        }

        ListNode previous = null;
        ListNode finalNode = null;
        for (int i=outcome.size()-1;i>=0;i--){
            ListNode listNode = new ListNode(outcome.get(i),previous);
            previous=listNode;
            finalNode=listNode;
        }

        return finalNode;
    }

    public int lengthOfLongestSubstring(String s) {
        int counter=0;
        for(int i=0;i<s.length();i++){
            List<Character> substring = new ArrayList<>();
            for(int j=i;j<s.length();j++){
                if(!substring.contains(s.charAt(j))){
                    substring.add(s.charAt(j));
                }
                else {
                    break;
                }
            }
            counter = substring.size()>counter?substring.size():counter;
        }

        return counter;
    }
}