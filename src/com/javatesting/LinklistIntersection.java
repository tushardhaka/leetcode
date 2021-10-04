package com.javatesting;

public class LinklistIntersection {

    public static void main(String[] args) {

    }
    public ListNode prepareListA(){

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9, l1);
        ListNode l3 = new ListNode(9, l2);
        ListNode l4 = new ListNode(9, l3);

        return l1;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        return headA;

    }


}
