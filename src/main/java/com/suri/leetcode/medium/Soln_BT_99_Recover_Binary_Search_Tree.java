package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.


Input Tree:
         10
        /  \
       5    8
      / \
     2   20


         10
        /  \
       5    20
      / \
     2   8

https://leetcode.com/problems/recover-binary-search-tree/
https://www.youtube.com/watch?v=2uPKWpMHmZA&t=615s&ab_channel=AlgorithmsMadeEasy
https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 */
public class Soln_BT_99_Recover_Binary_Search_Tree {

    TreeNode root;
    public static void main(String[] args) {

        Soln_BT_99_Recover_Binary_Search_Tree obj = new Soln_BT_99_Recover_Binary_Search_Tree();
        obj.createTree();
        obj.inOrder(obj.root);
        obj.recoverTree(obj.root);
        System.out.println();
        obj.inOrder(obj.root);
    }


    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev  = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        if(root==null){
            return;
        }
        recoverTreeUtil(root);
        int temp = first.val;
        first.val= second.val;
        second.val = temp;
    }


    public void recoverTreeUtil(TreeNode root){
        if(root==null){
            return;
        }
        recoverTreeUtil(root.left);
        if(first==null && prev.val>root.val){
            first = prev;
        }
        if(first!=null && prev.val >root.val){
            second = root;
        }
        prev = root;
        recoverTreeUtil(root.right);

    }


    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(" "+root.val);
        inOrder(root.right);
    }
    public void createTree() {
        this.root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(20);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right= n4;

    }
}
