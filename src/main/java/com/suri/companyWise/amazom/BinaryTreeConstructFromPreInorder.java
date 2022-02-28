package com.suri.companyWise.amazom;

/**
 * @History: Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 *
 * Soln:-
 * 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
 * 2) Create a new tree node tNode with the data as picked element.
 * 3) Find the picked element’s index in Inorder. Let the index be inIndex.
 * 4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
 * 5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
 * 6) return tNode.
 */
public class BinaryTreeConstructFromPreInorder {
  public static void main(String[] args) {

    int preorder[] = {3, 9, 20, 15, 7};
    int inorder[] = {9, 3, 15, 20, 7};

    ConstructBinaryTreeFromPreInorderTraversal constructBinaryTreeFromPreInorderTraversal =
            new ConstructBinaryTreeFromPreInorderTraversal();

    TreeNode root = constructBinaryTreeFromPreInorderTraversal.buildTree(preorder, inorder);
    constructBinaryTreeFromPreInorderTraversal.inOrder(root);
  }


}

class ConstructBinaryTreeFromPreInorderTraversal {
  int preOrderIndex = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    return buildTree(preorder, inorder, 0, inorder.length - 1);
  }


  public TreeNode buildTree(int[] preorder, int[] inorder, int inorderStartIndex, int inorderEndIndex) {

    if (inorderStartIndex > inorderEndIndex) {
      return null;
    }


    TreeNode newNode = new TreeNode(preorder[preOrderIndex]);

    preOrderIndex++;

    if (inorderStartIndex == inorderEndIndex) {
      return newNode;
    }
    int inorderIndex = search(inorder, newNode.val);

    newNode.left = buildTree(preorder, inorder, inorderStartIndex, inorderIndex - 1);
    newNode.right = buildTree(preorder, inorder, inorderIndex + 1, inorderEndIndex);

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