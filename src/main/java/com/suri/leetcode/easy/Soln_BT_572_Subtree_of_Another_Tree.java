package com.suri.leetcode.easy;

/*

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.



Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
https://leetcode.com/problems/subtree-of-another-tree/

 */

public class Soln_BT_572_Subtree_of_Another_Tree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){

        if(root==null && subRoot==null){
            return true;
        }

        return root!=null && subRoot!=null && root.val == subRoot.val && isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
    }
}
