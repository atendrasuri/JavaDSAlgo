package com.suri.leetcode.hard;

import com.suri.common.ListNode;

import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

https://leetcode.com/problems/merge-k-sorted-lists/

 */
public class Soln_23_MergekSortedLists {
    public static void main(String[] args) {


    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue <>();
        for(ListNode list : lists) {
            while(list!=null){
                minHeap.add(list.val) ;
                list = list.next;
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode startNode = dummyNode;
        while(!minHeap.isEmpty()){
            int data =  minHeap.remove();
            startNode.next = new ListNode(data);
            startNode = startNode.next;
        }

        return dummyNode.next;

    }
}
