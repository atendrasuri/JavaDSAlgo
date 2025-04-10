package com.suri.companyWise.amazom;


import com.suri.common.TreeNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the tree from bottom.
 * <p>
 * 20
 * /    \
 * 8       22
 * /   \        \
 * 5      3       25
 * /   \
 * 10    14
 * <p>
 * For the above tree, the bottom view is 5 10 3 14 25.
 */
public class BinaryTreeBottomView {

    public static void main(String[] args) {

        BinaryTreeBottomView binaryTreeBottomView = new BinaryTreeBottomView();
        binaryTreeBottomView.createTree();
       // binaryTreeBottomView.inOrder(binaryTreeBottomView.root);
        System.out.println();
        binaryTreeBottomView.bottomView(binaryTreeBottomView.root);


    }

    TreeNode root;

    public void createTree() {
        this.root = new TreeNode(1);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);


        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(9);


        TreeNode n8 = new TreeNode(7);


        root.left = n1;
        root.right = n2;

        n1.left = n4;
        n1.right = n5;

        n4.left = n6;
        n4.right = n7;


        n2.right = n8;

    }

    public void bottomView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        bottomView(map, root, 0);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }

    public void bottomView(TreeMap<Integer, Integer> map, TreeNode root, int hd) {

        if (root == null) {
            return;
        }
        map.put(hd, root.val);
        bottomView(map, root.left, hd - 1);
        bottomView(map, root.right, hd + 1);
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