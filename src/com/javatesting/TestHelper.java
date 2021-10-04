package com.javatesting;

public class TestHelper {

    public static void main(String[] args) {

        Integer backlog = 501;
        Integer capacity = 100;
        Integer tat = 96;

        backlog = (backlog == null) ? 0 : backlog;
        capacity = (capacity == null) ? Integer.MIN_VALUE : capacity;
        tat = (tat == null) ? 0 : tat;
        int days = capacity <= 0 ? -2 : ((int) Math.ceil((backlog - ((float) capacity * tat) / 24) / (float) capacity));
        days = days <= -2 ? -2 : days;

        System.out.println(days);

    }
}
