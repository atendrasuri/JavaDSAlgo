package com.suri.leetcode.medium;

import com.suri.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Example 1:


Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
 */
public class Soln_BT_117_Populating_Next_Right_Pointers_in_Each_Node_II {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {

        if(root==null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);


        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0;i<size;i++){

                Node temp = queue.remove();
                if(i<size-1){
                    temp.next = queue.peek();
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }

                if(temp.right!=null){
                    queue.add(temp.right);
                }

            }
        }
        return root;
    }
}
