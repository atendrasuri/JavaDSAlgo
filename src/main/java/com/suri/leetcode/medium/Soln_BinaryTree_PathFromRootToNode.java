package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 Problem Description

 Given a Binary Tree A containing N nodes.

 You need to find the path from Root to a given node B.

 NOTE:

 No two nodes in the tree have same data values.
 You can assume that B is present in the tree A and a path always exists
 https://www.interviewbit.com/problems/path-to-given-node/#
 https://www.youtube.com/watch?v=fmflMqVOC7k&ab_channel=takeUforward
 */
public class Soln_BinaryTree_PathFromRootToNode {
    TreeNode root;
    public static void main(String[] args) {

        Soln_BinaryTree_PathFromRootToNode ob  = new Soln_BinaryTree_PathFromRootToNode();
        ob.createTree();
        System.out.println(ob.pathFromRootToNode(ob.root, 15));

    }
    public List<Integer> pathFromRootToNode(TreeNode A, int B) {
        List<Integer> list = new ArrayList<>();
        path(A, B, list);
        return list;
    }
    public boolean path(TreeNode node, int B, List<Integer> list) {
        if (node == null) {
            return false;
        }
        list.add(node.val);
        if (node.val == B) {
            return true;
        }
        if (path(node.left, B, list) || path(node.right, B, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
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