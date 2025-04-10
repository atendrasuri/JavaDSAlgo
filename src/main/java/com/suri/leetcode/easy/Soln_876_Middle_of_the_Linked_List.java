package com.suri.leetcode.easy;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.



Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

https://leetcode.com/problems/middle-of-the-linked-list

 */

import com.suri.common.ListNode;

public class Soln_876_Middle_of_the_Linked_List {

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {


        ListNode slow = head;
        ListNode fast = head;

        int count =0;

        while(fast.next!=null){

            count++;
            if(count%2==0){
                slow = slow.next;
            }
            fast = fast.next;
        }

        if(count%2==0){
            return slow;
        }
        return slow.next;

    }
}
