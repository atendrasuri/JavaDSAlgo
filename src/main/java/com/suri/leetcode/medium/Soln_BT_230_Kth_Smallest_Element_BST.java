package com.suri.leetcode.medium;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */

import com.suri.common.TreeNode;

public class Soln_BT_230_Kth_Smallest_Element_BST {

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {

        if(root==null){
            return -1;
        }

        int num[] = new int[2];
        kthSmallest(root, num, k);
        return num[1];

    }

    public void kthSmallest(TreeNode root, int num[], int k){

        if(root==null){
            return;
        }

        kthSmallest(root.left, num, k);
        if(++num[0]==k){
            num[1]=root.val;
        }
        kthSmallest(root.right, num, k);
    }


}
