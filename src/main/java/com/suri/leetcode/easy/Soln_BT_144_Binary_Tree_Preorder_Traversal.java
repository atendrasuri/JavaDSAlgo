package com.suri.leetcode.easy;
/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]
https://leetcode.com/problems/binary-tree-preorder-traversal
 */

import java.util.ArrayList;
import java.util.List;

public class Soln_BT_144_Binary_Tree_Preorder_Traversal {
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;

    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
