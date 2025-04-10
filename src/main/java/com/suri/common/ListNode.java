package com.suri.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){

    }

    public ListNode(int val) {

        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {

        this.val = val;
        next = next;
    }
}