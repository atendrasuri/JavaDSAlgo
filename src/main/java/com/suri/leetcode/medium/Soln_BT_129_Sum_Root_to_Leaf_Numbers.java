package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.



Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
https://leetcode.com/problems/sum-root-to-leaf-numbers
 */
public class Soln_BT_129_Sum_Root_to_Leaf_Numbers {
    public static void main(String[] args) {

    }
    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode root, int sum){

        if(root==null){
            return 0;
        }

        sum = sum*10+root.val;
        if(root.left == null && root.right==null){
            return sum;
        }

        return sumNumbers(root.left,sum)+sumNumbers(root.right, sum);
    }
}
