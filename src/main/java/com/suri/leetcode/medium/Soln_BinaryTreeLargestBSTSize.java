package com.suri.leetcode.medium;

/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.
Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.

Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2
Output: 2
Explanation: The following sub-tree is a
BST of size 2:
       2
    /    \
   N      8

   https://practice.geeksforgeeks.org/problems/largest-bst/1/

 */
public class Soln_BinaryTreeLargestBSTSize {
    TreeNode root;
    public static void main(String[] args) {

        Soln_BinaryTreeLargestBSTSize ob = new Soln_BinaryTreeLargestBSTSize();
        ob.createTree();
        System.out.println(ob.largestBstInBT(ob.root).size);

        System.out.println(ob.largestBstInBT1(ob.root));
    }

    static class BSTPair {
        boolean isBST;
        int min;
        int max;
        int size;
        TreeNode root;
    }
    static BSTPair largestBstInBT(TreeNode root) {
        if (root == null) {
            BSTPair basePair = new BSTPair();
            basePair.isBST = true;
            basePair.min = Integer.MAX_VALUE;
            basePair.max = Integer.MIN_VALUE;
            basePair.size = 0;
            basePair.root = null;
            return basePair;

        }
        BSTPair lp = largestBstInBT(root.left);
        BSTPair rp = largestBstInBT(root.right);
        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (root.val >= lp.max && root.val <= rp.min);
        mp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.val, Math.min(lp.max, rp.max));

        if (mp.isBST) {
            mp.root = root;
            mp.size = lp.size + rp.size + 1;
        } else if (lp.size > rp.size) {

            mp.root = lp.root;
            mp.size = lp.size;
        } else {
            mp.root = rp.root;
            mp.size = rp.size;
        }
        return mp;

    }

    /*
    Second approach
     */

    public static int largestBstInBT1(TreeNode root) {

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
        return Math.max(largestBstInBT1(root.left), largestBstInBT1(root.right));

    }

    public static boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }
    public void createTree() {
        this.root = new TreeNode(1);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right= n4;
    }
}
