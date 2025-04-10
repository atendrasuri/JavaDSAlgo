package com.suri.leetcode.medium;
/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

import com.suri.common.ListNode;

public class Soln_82_Remove_Duplicates_from_Sorted_List_II {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pred = dummy;
        while(head!=null){
            if(head.next!=null && head.val == head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head = head.next;
                }
                pred.next = head.next;
            }else{
                pred = pred.next;
            }
            head = head.next;
        }
        return dummy.next;


    }
}
