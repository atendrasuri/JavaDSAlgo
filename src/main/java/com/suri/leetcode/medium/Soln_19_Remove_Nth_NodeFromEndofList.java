package com.suri.leetcode.medium;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.


 Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

 */

import com.suri.common.ListNode;

public class Soln_19_Remove_Nth_NodeFromEndofList {
    public static void main(String[] args) {


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while(right!=null && n>0){
            right = right.next;
            n= n-1;
        }
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
