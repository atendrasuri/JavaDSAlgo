package com.suri.leetcode.easy;

import com.suri.ListNode;

import java.util.PriorityQueue;


/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 */
public class Soln_21_MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while(l1!=null){
            minHeap.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            minHeap.add(l2.val);
            l2=l2.next;
        }
        ListNode start=null;

        while(!minHeap.isEmpty()){
            if(start==null){
                start = new ListNode(minHeap.remove());
            }else{
                ListNode t = start;
                while(t.next!=null){
                    t=t.next;
                }
                t.next = new ListNode(minHeap.remove());
            }

        }
        return start;

    }

    public ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        while (list1 != null) {
            result.next = list1;
            list1 = list1.next;
            result = result.next;
        }
        while (list2 != null) {
            result.next = list2;
            list2 = list2.next;
            result = result.next;
        }
        return dummy.next;
    }
    public void display(ListNode start) {
        if (start == null) {
            System.out.println(" List is empty");
        }

        ListNode temp = start;
        while (temp != null) {
            System.out.print("  " + temp.val);
            temp = temp.next;
        }
    }

    public void insertNode(ListNode head, int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(data);
    }



}
