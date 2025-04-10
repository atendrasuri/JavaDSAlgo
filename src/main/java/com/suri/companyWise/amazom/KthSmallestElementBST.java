package com.suri.companyWise.amazom;

import com.suri.common.TreeNode;

/**
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
 2
 Output: 1
 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 Output: 3
 */
public class KthSmallestElementBST {
  public static void main(String[] args) {

  }

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return -1;
    }
    int num[] = new int[2];

    inOrder(root, num, k);
    return num[1];

  }

  public void inOrder(TreeNode root, int num[], int k) {

    if (root == null) {
      return;
    }

    inOrder(root.left, num, k);
    if (++num[0] == k) {
      num[1] = root.val;
      return;
    }
    inOrder(root.right, num, k);
  }
}