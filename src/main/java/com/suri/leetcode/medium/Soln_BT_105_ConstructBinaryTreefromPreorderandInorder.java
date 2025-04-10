package com.suri.leetcode.medium;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */

import com.suri.common.TreeNode;

public class Soln_BT_105_ConstructBinaryTreefromPreorderandInorder {

    int preIndex=0;

    public static void main(String[] args) {
        int preorder[] = {3, 9, 20, 15, 7};
        int inorder[] = {9, 3, 15, 20, 7};
        Soln_BT_105_ConstructBinaryTreefromPreorderandInorder obj = new Soln_BT_105_ConstructBinaryTreefromPreorderandInorder();

        TreeNode root =  obj.buildTree(preorder, inorder);

        obj.inOrder(root);

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return  buildTree(preorder, inorder, 0, inorder.length-1);

    }



    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end){

        if(start>end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if(start==end){
            return root;
        }
        int index = search(root.val, inorder);
        root.left = buildTree(preorder, inorder,start, index-1 );
        root.right = buildTree(preorder, inorder,index+1,end );
        return root;
    }


    public int search(int key, int[] inorder){

        for(int i=0;i<inorder.length;i++){

            if(key==inorder[i]){
                return i;
            }
        }
        return -1;

    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
