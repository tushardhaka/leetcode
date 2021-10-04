package com.javatesting;

import java.util.*;

public class LazyIntern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int columns = 8;
        int rows = scanner.nextInt();
        Map<Integer, Integer> vacantSeats = new HashMap<>();
        int managerSeat;
        for(int i=0;i<rows;i++){
            String rowData = scanner.next();
            System.out.println("-->"+rowData);
            managerSeat = rowData.indexOf('M');
            int startIndex = 0;
            while(rowData.indexOf('V',0)>0){
                startIndex = rowData.indexOf('V');
                vacantSeats.put(i+1,startIndex+1);
            }
        }
        vacantSeats.forEach((k,v)-> System.out.println(k+","+v));

    }
}
