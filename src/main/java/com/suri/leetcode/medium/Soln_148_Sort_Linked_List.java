package com.suri.leetcode.medium;

import com.suri.common.ListNode;

/*
Given the head of a linked list, return the list after sorting it in ascending order.



Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
https://leetcode.com/problems/sort-list/description
 */
public class Soln_148_Sort_Linked_List {
    public static void main(String[] args) {

    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode list1, ListNode list2){

        ListNode dummyNode = new ListNode();
        ListNode temp = dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                temp = temp.next;
                list1= list1.next;
            }else{
                temp.next= list2;
                list2= list2.next;
                temp = temp.next;
            }
        }
        temp.next = (list1!=null)?list1:list2;
        return dummyNode.next;
    }



    public ListNode getMid(ListNode head){
        ListNode slow = null;
        while(head!=null && head.next!=null){
            slow = (slow==null)?head:slow.next;
            head= head.next.next;
        }
        ListNode mid = slow.next;
        slow.next=null;
        return mid;
    }
}
