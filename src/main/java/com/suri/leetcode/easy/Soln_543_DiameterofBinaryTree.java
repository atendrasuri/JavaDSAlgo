package com.suri.leetcode.easy;

import com.suri.leetcode.medium.Soln_BinaryTree_PathFromNodeToRoot;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class Soln_543_DiameterofBinaryTree {
    TreeNode root;
    public static void main(String[] args) {

        Soln_543_DiameterofBinaryTree ob  = new Soln_543_DiameterofBinaryTree();
        ob.createTree();
        System.out.println(ob.diameter(ob.root));

        System.out.println(ob.diameterOptimize(ob.root).dt);

    }
    public int diameter(TreeNode root) {

        if(root==null){
            return 0;
        }
        int ld= diameter(root.left);
        int rd = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh+rh, Math.max(ld, rd));

    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh)+1;
    }

    public Diapair diameterOptimize(TreeNode root) {
        if (root == null) {
            Diapair basePair = new Diapair();
            basePair.ht = 0;
            basePair.dt = 0;
            return basePair;
        }
        Diapair ld = diameterOptimize(root.left);
        Diapair rd = diameterOptimize(root.right);
        Diapair mypair = new Diapair();
        mypair.ht = Math.max(ld.ht, rd.ht) + 1;
        int f = ld.ht + rd.ht;
        mypair.dt = Math.max(f, Math.max(ld.dt, rd.dt));
        return mypair;
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

    class Diapair{
        int ht;
        int dt;
    }
}
