package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
         26
        /   \
      10     3
    /    \     \
  4      6      3

  [26, 3, 10, 4, 6, 3]

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Soln_103_BinaryTreeZigzagLevelOrderTraversal {
    TreeNode root;
    public static void main(String[] args) {

        Soln_103_BinaryTreeZigzagLevelOrderTraversal obj = new Soln_103_BinaryTreeZigzagLevelOrderTraversal();
        obj.createTree();
        //System.out.println(obj.zigZagTraversal(obj.root));
        System.out.println(obj.zigzagLevelOrder(obj.root));
    }

    public ArrayList<Integer> zigZagTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while ((!s1.isEmpty()) || (!s2.isEmpty())) {
            while (!s1.isEmpty()) {
                TreeNode temp = s1.pop();
                result.add(temp.val);
                if (temp.left != null) {
                    s2.push(temp.left);
                }
                if (temp.right != null) {
                    s2.push(temp.right);
                }
            }
            while (!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                result.add(temp.val);
                if (temp.right != null) {
                    s1.push(temp.right);
                }
                if (temp.left != null) {
                    s1.push(temp.left);
                }
            }
        }
        return result;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while ((!s1.isEmpty()) || (!s2.isEmpty())) {
            List<Integer> inner = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode temp = s1.pop();
                inner.add(temp.val);
                if (temp.left != null) {
                    s2.push(temp.left);
                }
                if (temp.right != null) {
                    s2.push(temp.right);
                }
            }
            if(!inner.isEmpty()){
                result.add(inner);
            }
            inner = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                inner.add(temp.val);

                if (temp.right != null) {
                    s1.push(temp.right);
                }
                if (temp.left != null) {
                    s1.push(temp.left);
                }
            }
            if(!inner.isEmpty()){
                result.add(inner);
            }

        }
        return result;
    }

    public void createTree() {
        this.root = new TreeNode(26);
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(3);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right= n4;
        n2.right = n5;

    }
}
