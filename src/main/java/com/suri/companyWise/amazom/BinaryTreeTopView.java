package com.suri.companyWise.amazom;


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
public class BinaryTreeTopView {

  TreeNode root;

  public static void main(String[] args) {

    BinaryTreeTopView binaryTreeTopView = new BinaryTreeTopView();
    binaryTreeTopView.createTree();
    System.out.println();
    binaryTreeTopView.topView(binaryTreeTopView.root);


  }

  static void topView(TreeMap<Integer, Integer> map, TreeNode root, int hd) {

    if (root == null) {
      return;
    }

    if (map.get(hd) != null) {

    } else {
      System.out.print(root.val + " ");
      map.put(hd, root.val);
    }

    topView(map, root.left, hd - 1);
    topView(map, root.right, hd + 1);

  }

  public static void topView(TreeNode root) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    topView(map, root, 0);


  }

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


}