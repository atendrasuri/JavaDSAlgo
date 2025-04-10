package com.suri.leetcode.easy;
/*
Given the head of a singly linked list, return true if it is a
palindrome
 or false otherwise.



Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false

https://leetcode.com/problems/palindrome-linked-list
 */

import com.suri.common.ListNode;

import java.util.Stack;

public class Soln_234_Palindrome_Linked_List {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;

        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }

        while(!stack.isEmpty()){

            int val = stack.pop();
            if(val!=head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
