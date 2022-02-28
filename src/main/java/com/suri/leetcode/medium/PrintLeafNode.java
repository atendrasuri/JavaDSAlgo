package com.suri.leetcode.medium;

public class PrintLeafNode {


    TreeNode root;
    public static void main(String[] args) {

        PrintLeafNode obj = new PrintLeafNode();

        obj.root = new TreeNode(0);
        obj.root.left = new TreeNode(1);
        obj.root.right = new TreeNode(2);

        obj.root.left.left = new TreeNode(3);
        obj.root.left.right = new TreeNode(4);

        obj.root.right.left = new TreeNode(5);

        obj.root.right.right = new TreeNode(6);

        obj.printLeaf(obj.root);
    }


    public void printLeaf(TreeNode root){

        if(root==null){
            return;
        }
        printLeaf(root.left);
        if(root.left==null && root.right==null){
            System.out.print(root.val +"  ");
        }
        printLeaf(root.right);

    }
}
