package com.suri.leetcode.easy;
/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.



Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
https://leetcode.com/problems/count-complete-tree-nodes
 */

public class Soln_BT_222_Count_Complete_Tree_Nodes {
    public static void main(String[] args) {

    }
    public static int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+ countNodes(root.left)+countNodes(root.right);

    }
}
