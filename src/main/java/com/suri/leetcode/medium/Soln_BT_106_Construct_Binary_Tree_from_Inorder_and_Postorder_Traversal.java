package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

 */
public class Soln_BT_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    int postorderIndex =1;
    public static void main(String[] args) {

    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end){

        if(start>end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - postorderIndex]);
        postorderIndex++;
        if(start==end){
            return root;
        }

        int index = search(inorder, root.val);
        root.right = buildTree(inorder, postorder, index+1, end);
        root.left = buildTree(inorder, postorder, start, index-1);
        return root;
    }

    public int search(int[] inorder, int num){

        for(int i=0;i<inorder.length; i++){
            if(inorder[i]==num){
                return i;
            }
        }
        return -1;
    }
}
