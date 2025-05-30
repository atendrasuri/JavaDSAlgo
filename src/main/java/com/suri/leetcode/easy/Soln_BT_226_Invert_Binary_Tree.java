package com.suri.leetcode.easy;
/*
Given the root of a binary tree, invert the tree, and return its root.



Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
https://leetcode.com/problems/invert-binary-tree
 */
public class Soln_BT_226_Invert_Binary_Tree {
    public static void main(String[] args) {

    }
    public static TreeNode invertTree(TreeNode root) {

        if(root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right= temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
