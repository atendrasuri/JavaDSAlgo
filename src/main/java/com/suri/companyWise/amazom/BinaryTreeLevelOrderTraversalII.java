package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
  public static void main(String[] args) {
    BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
    TreeNode root = new TreeNode(2);
    binaryTreeLevelOrder.levelOrderBottom(root);

  }
}

class BinaryTreeLevelOrder {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> res = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode temp = queue.remove();
        res.add(temp.val);
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
      result.add(0, res);
    }
    return result;
  }
}