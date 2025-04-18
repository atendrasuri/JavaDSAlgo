package com.suri.leetcode.hard;

import com.suri.common.TreeNode;

/*

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

https://leetcode.com/problems/binary-tree-maximum-path-sum/
https://www.youtube.com/watch?v=Hr5cWUld4vU&list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf&index=62&ab_channel=NeetCode

 */
public class Soln_124_Binary_Tree_Maximum_Path_Sum {
    int maxSum = Integer.MIN_VALUE;
    TreeNode root;
    public static void main(String[] args) {
        Soln_124_Binary_Tree_Maximum_Path_Sum ob = new Soln_124_Binary_Tree_Maximum_Path_Sum();
        ob.createTree();
        System.out.println(ob.maxPathSum(ob.root));
    }


    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxSum;
    }

    public int maxPathSumUtil(TreeNode root) {

        if(root==null){
            return 0;
        }

        int maxLeft = maxPathSumUtil(root.left);
        int maxRight = maxPathSumUtil(root.right);
        maxLeft = Math.max(maxLeft, 0);
        maxRight = Math.max(maxRight, 0);

        maxSum = Math.max(maxSum, root.val+maxLeft+maxRight);
        return Math.max(maxLeft, maxRight)+ root.val;
    }


    public void createTree() {
        //-10,9,20,null,null,15,7
        this.root = new TreeNode(10);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right= n4;
    }
}
