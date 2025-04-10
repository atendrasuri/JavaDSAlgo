package com.suri.companyWise.amazom;

import com.suri.common.TreeNode;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    Soln:- 1) Pick an element from postOrder. Decrement a postOrder Index Variable (postIndex in below code) to pick next element in next recursive call.
 *  * 2) Create a new tree node tNode with the data as picked element.
 *  * 3) Find the picked element’s index in Inorder. Let the index be inIndex.
 *  * 4) Call buildTree for elements before inIndex and make the built tree as right subtree of tNode.
 *  * 5) Call buildTree for elements after inIndex and make the built tree as left subtree of tNode.
 *  * 6) return tNode.
 */
public class BinaryTreeConstructFromInorderPostorder {
  public static void main(String[] args) {

    int inorder[] = {3, 9, 20, 15, 7};
    int postorder[] = {9, 15, 7, 20, 3};

    ConstructBinaryTreeFromInorderPostorderTraversal constructBinaryTreeFromInorderPostorder =
            new ConstructBinaryTreeFromInorderPostorderTraversal();
    TreeNode root = constructBinaryTreeFromInorderPostorder.buildTree(inorder, postorder);
    constructBinaryTreeFromInorderPostorder.inOrder(root);

  }
}

class ConstructBinaryTreeFromInorderPostorderTraversal {

  int postOrderIndex = 1;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, postorder, 0, inorder.length - 1);
  }

  public TreeNode buildTree(int[] inorder, int[] postorder, int inOrderStartIndex, int inOrderEendIndex) {

    if (inOrderStartIndex > inOrderEendIndex) {
      return null;
    }


    TreeNode newNode = new TreeNode(postorder[postorder.length - postOrderIndex]);

    postOrderIndex++;

    if (inOrderStartIndex == inOrderEendIndex) {
      return newNode;
    }
    int inorderIndex = search(inorder, newNode.val);
    newNode.right = buildTree(inorder, postorder, inorderIndex + 1, inOrderEendIndex);
    newNode.left = buildTree(inorder, postorder, inOrderStartIndex, inorderIndex - 1);

    return newNode;

  }

  public int search(int inorder[], int key) {
    if (inorder.length == 0) {
      return -1;
    }

    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == key) {
        return i;
      }
    }
    return -1;
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