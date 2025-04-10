package com.suri.leetcode.easy;

/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]

https://leetcode.com/problems/remove-duplicates-from-sorted-list
 */

import com.suri.common.ListNode;

public class Soln_83_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode current = head;


        while(current!=null && current.next!=null){

            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;

    }
}
