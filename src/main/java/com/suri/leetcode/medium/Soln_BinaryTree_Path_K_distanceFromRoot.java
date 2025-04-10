package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.ArrayList;

/*
Given a Binary Tree of size N and an integer K. Print all nodes that are at distance k from root (root is considered at distance 0 from itself). Nodes should be printed from left to right. If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6
     \
      8

Example 1:

Input:
K = 0
      1
    /   \
   3     2
Output: 1

Example 2:

Input:
K = 3
        3
       /
      2
       \
        1
      /  \
     5    3
Output: 5 3
https://practice.geeksforgeeks.org/problems/k-distance-from-root

 */
public class Soln_BinaryTree_Path_K_distanceFromRoot {
    public static void main(String[] args) {

    }

    ArrayList<Integer> KdistanceFromRoot(TreeNode root, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        KdistanceFromRoot(root, k, result);
        return result;

    }

    void KdistanceFromRoot(TreeNode root, int k, ArrayList<Integer> result) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(root.val);
        }
        KdistanceFromRoot(root.left, k - 1, result);
        KdistanceFromRoot(root.right, k - 1, result);

    }
}
