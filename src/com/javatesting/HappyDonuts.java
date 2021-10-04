package com.javatesting;

import java.util.*;

public class HappyDonuts {
    public static void main(String[] args) {

        int[] groups = new int[]{1,1,2,3,4,5,6};
        int batchSize = 4;
        HappyDonuts happyDonuts = new HappyDonuts();
        System.out.println(happyDonuts.maxHappyGroups(batchSize, groups));
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        int output = 0;

        List<Integer> groupList = new ArrayList<>();

        for(int i : groups){
            groupList.add(i);
        }
        for(int i : groups){
            if(i==batchSize || i%batchSize==0){
                groupList.remove(i);
                output++;
            }
        }

        Integer [] newGroups = new Integer[groupList.size()];
        groupList.toArray(newGroups);

        for(int i : newGroups){

        }


        return output;
    }
}
