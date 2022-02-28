package com.suri.leetcode.medium;

/*
Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and the sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

         26
        /   \
      10     3
    /    \     \
  4      6      3

  https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

 */
public class Soln_BinaryTreeIsSumTree {
    TreeNode root;
    public static void main(String[] args) {
        Soln_BinaryTreeIsSumTree soln_binaryTreeIsSumTree = new Soln_BinaryTreeIsSumTree();
        soln_binaryTreeIsSumTree.createTree();
        System.out.println(soln_binaryTreeIsSumTree.isSumTree(soln_binaryTreeIsSumTree.root));

    }
    public boolean isSumTree(TreeNode root){

        if(root==null || (root.left==null && root.right==null)){
            return true;
        }

        int ls = sum((root.left));
        int rs = sum((root.right));

        if(ls+rs == root.val && isSumTree(root.left) && isSumTree(root.right)){
            return true;
        }
        return false;
    }

    public static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + node.val + sum(node.right);
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
