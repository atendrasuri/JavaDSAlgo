package com.suri.leetcode.medium;
/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

import com.suri.common.TreeNode;

public class Soln_BT_114_Flatten_Binary_Tree_Linked_List {
    public static void main(String[] args) {

        Soln_BT_114_Flatten_Binary_Tree_Linked_List ob = new Soln_BT_114_Flatten_Binary_Tree_Linked_List();
        ob.createTree();
        ob.flatten(ob.root);

        ob.display(ob.root);

    }

    TreeNode current;
    TreeNode root;
    public void flatten(TreeNode root) {

        current=null;
        dfs(root);
    }

    public void dfs(TreeNode root){

        if(root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;


        if(current!=null){
            current.left = null;
            current.right=root;

        }
        current=root;
        dfs(left);
        dfs(right);
    }

    public void createTree() {
        this.root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n1.right = n3;

        n4.right=n5;
    }
    public void display(TreeNode root){

        while(root!=null){
            System.out.print(root.val+"  ");
            root= root.right;
        }
    }
}
