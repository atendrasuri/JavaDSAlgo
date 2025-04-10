package com.suri.leetcode.easy;

import com.suri.common.ListNode;

/*

You are given a singly linked list and pointer which is pointing to the node which is required to be deleted. Any information about head pointer or any other node is not given. You need to write a function to delete that node from linked list. Your function will take only one argument: pointer to the node which is to be deleted.

Note: No head reference is given to you. It is guaranteed that the node to be deleted is not the last node;
https://www.geeksforgeeks.org/delete-a-node-from-linked-list-without-head-pointer/

https://leetcode.com/problems/delete-node-in-a-linked-list/discuss/1087547/delete-node-without-head-pointer-easy-cc-solution-with-steps
Take a temporary pointer i.e. temp.
Store the address of the next node to the given node in the temp i.e. ListNode *temp = node->next.
Copy the data (val) of the next node to the given node into the data (val) field of the given node i.e. node->val = temp->val OR node->val = node->next->val.
Now we have to delete the next node to the given node, hence change the next field of the given node to the next to next node i.e node->next = temp->next OR node->next = node->next->next.
Make next field of the node to be deleted as NULL i.e temp->next = NULL (To disconnect the link).
Delete that node i.e delete temp.
 */
public class Soln_9990_DeleteNodeWithoutHeadPointer {
    public  ListNode head;
    public static void main(String[] args) {
        Soln_9990_DeleteNodeWithoutHeadPointer ob = new Soln_9990_DeleteNodeWithoutHeadPointer();
        ob.head = new ListNode(1);
        ob.head.next= new ListNode(2);
        ob.head.next.next= new ListNode(3);
        ob.head.next.next.next= new ListNode(4);
        ob.head.next.next.next.next= new ListNode(5);
        ob.display(ob.head);
        ob.deleteNodeWithoutHeadPointer(ob.head.next.next);
        ob.display(ob.head);
    }

    public void display(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public void deleteNodeWithoutHeadPointer(ListNode listNode){

        if(listNode==null){
            return;
        }
        ListNode temp = listNode.next;
        listNode.val = listNode.next.val;
        listNode.next = listNode.next.next;
        temp=null;
    }
}
