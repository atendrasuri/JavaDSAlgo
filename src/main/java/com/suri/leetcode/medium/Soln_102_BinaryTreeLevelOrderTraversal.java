package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Example 1:

Input:
    1
  /   \
 3     2
Output:1 3 2

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Soln_102_BinaryTreeLevelOrderTraversal {
    TreeNode root;
    public static void main(String[] args) {
        Soln_102_BinaryTreeLevelOrderTraversal ob  = new Soln_102_BinaryTreeLevelOrderTraversal();
        ob.createTree();
        ob.levelOrder(ob.root);

        System.out.println(ob.levelOrder(ob.root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> innerres = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                innerres.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            result.add(innerres);
        }
        return result;
    }

    public void createTree() {
        this.root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

    }
}
