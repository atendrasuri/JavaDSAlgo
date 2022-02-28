package com.suri.leetcode.medium;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Input: root = [2,1,3]
Output: true


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Soln_98_IsBinaryTreeValidBST {
    TreeNode root;
    public static void main(String[] args) {
        Soln_98_IsBinaryTreeValidBST ob = new Soln_98_IsBinaryTreeValidBST();
        ob.createTree();
        System.out.println(ob.isValidBST(ob.root));

        BSTPair pair = ob.isValidBST1(ob.root);
        System.out.println(pair.isBST);

    }

    public boolean isValidBST(TreeNode root) {
        Long max = Long.MAX_VALUE;
        Long min = Long.MIN_VALUE;
        return isValidBST(root, min, max);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public void createTree() {
        this.root = new TreeNode(50);
        TreeNode n1 = new TreeNode(25);
        TreeNode n2 = new TreeNode(75);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(37);
        TreeNode n5 = new TreeNode(62);
        TreeNode n6 = new TreeNode(87);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
    }

    public class BSTPair{

        boolean isBST;
        int min;
        int max;

    }

    public BSTPair isValidBST1(TreeNode root) {

        if (root == null) {
            BSTPair basePair = new BSTPair();
            basePair.isBST = true;
            basePair.min = Integer.MAX_VALUE;
            basePair.max = Integer.MIN_VALUE;
            return basePair;
        }
        BSTPair lp = isValidBST1(root.left);
        BSTPair rp = isValidBST1(root.right);
        BSTPair myPair = new BSTPair();
        myPair.isBST = lp.isBST && rp.isBST && (root.val >= lp.max && root.val <= rp.min);
        myPair.min = Math.min(root.val, Math.min(lp.min, rp.min));
        myPair.max = Math.max(root.val, Math.max(lp.max, rp.max));
        return myPair;
    }

}
