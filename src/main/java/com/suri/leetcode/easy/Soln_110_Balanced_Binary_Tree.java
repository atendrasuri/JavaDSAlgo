package com.suri.leetcode.easy;

/*
Given a binary tree, determine if it is
height-balanced
.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
https://leetcode.com/problems/balanced-binary-tree/description/

 */

public class Soln_110_Balanced_Binary_Tree {

    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh-rh)>1){
            return false;
        }

        return isBalanced(root.left)&& isBalanced(root.right);

    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1+Math.max(height(root.left), height(root.right));
    }
}
