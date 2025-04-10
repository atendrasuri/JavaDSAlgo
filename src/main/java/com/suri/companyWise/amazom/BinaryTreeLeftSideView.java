package com.suri.companyWise.amazom;


import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a binary tree, imagine yourself standing on the left side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * Input:
 * 2
 * 2
 * 1 2 R 1 3 L
 * 4
 * 10 20 L 10 30 R 20 40 L 20 60 R
 *
 * Output:
 * 1 3
 * 10 20 40
 *
 * Explanation:
 * Testcase 2: below is a given tree with its nodes.
 */

public class BinaryTreeLeftSideView {
  public static void main(String[] args) {

    BinaryTreeLeftSideView binaryTreeLeftSideView = new BinaryTreeLeftSideView();
    binaryTreeLeftSideView.createTree();
    System.out.println(binaryTreeLeftSideView.rightSideView(binaryTreeLeftSideView.root));


  }

  TreeNode root;

  public void createTree() {
    this.root = new TreeNode(5);

    TreeNode n1 = new TreeNode(4);
    TreeNode n2 = new TreeNode(8);

    TreeNode n4 = new TreeNode(11);
    TreeNode n5 = new TreeNode(13);
    TreeNode n6 = new TreeNode(4);


    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(2);
    TreeNode n9 = new TreeNode(5);
    TreeNode n10 = new TreeNode(1);

    root.left = n1;
    root.right = n2;

    n1.left = n4;

    n2.left = n5;
    n2.right = n6;

    n4.left = n7;
    n4.right = n8;

    n6.left = n9;
    n6.right = n10;
  }

  public List<Integer> rightSideView(TreeNode root) {


    List<Integer> rightSideView = new ArrayList<>();
    if (root == null) {
      return rightSideView;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.remove();
        if (i == size - 1) {
          rightSideView.add(current.val);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
        if (current.left != null) {
          queue.add(current.left);
        }

      }


    }
    return rightSideView;

  }
}