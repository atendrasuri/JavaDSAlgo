package com.suri.leetcode.hard;

import com.suri.ListNode;
/*

Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).
Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5
Explanation:
The first 4 elements 1,2,2,4 are reversed first
and then the next 4 elements 5,6,7,8. Hence, the
resultant linked list is 4->2->2->1->8->7->6->5.

Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4
Explanation:
The first 3 elements are 1,2,3 are reversed
first and then elements 4,5 are reversed.Hence,
the resultant linked list is 3->2->1->5->4.
https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class Soln_25_LinkedListReverseNodesInk_Group {
    public static void main(String[] args) {

    }

    public static ListNode reverse(ListNode node, int k)
    {
        return reverse(node, k, 0);
    }


    public static ListNode reverse(ListNode head, int k, int count) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while (currentNode != null && count < k) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        if (nextNode != null) {

            head.next = reverse(nextNode, k, 0);
        }
        return prevNode;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(head, k, 0);

    }

    public static ListNode reverseKGroup(ListNode head, int k, int count) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current_node = head;
        ListNode prev_node = null;
        ListNode next_node = head;
        for (int i = 0; i < k; i++) {
            if (next_node == null)
                return head;
            next_node = next_node.next;
        }
        while (current_node != null && count < k) {
            next_node = current_node.next;
            current_node.next = prev_node;
            prev_node = current_node;
            current_node = next_node;
            count++;
        }
        if (next_node != null) {
            head.next = reverseKGroup(next_node, k, 0);
        }
        return prev_node;
    }
}
