package com.suri.companyWise.amazom;

import com.suri.common.TreeNode;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class BinaryTreeConvertToGreaterTree {
  public static void main(String[] args) {

    ConvertBSTGreaterSoln convertBSTGreaterSoln = new ConvertBSTGreaterSoln();
    convertBSTGreaterSoln.inOrder(convertBSTGreaterSoln.root);

    convertBSTGreaterSoln.createTree();

    convertBSTGreaterSoln.inOrder(convertBSTGreaterSoln.convertBST(convertBSTGreaterSoln.root));




  }



}
class ConvertBSTGreaterSoln{

  TreeNode root;

  public void createTree() {
    this.root = new TreeNode(5);

    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(13);

    root.left = n1;
    root.right = n2;


  }

  class Sum{
    int sum;
  }
  public TreeNode convertBST(TreeNode root) {

    if(root==null){
      return null;
    }
    convertBST(root,new Sum());
    return root;


  }

  public void convertBST(TreeNode root, Sum s) {

    if(root==null){
      return;
    }
    convertBST(root.right,s);
    s.sum = s.sum+root.val;
    root.val = s.sum;
    convertBST(root.left,s);


  }

  public void inOrder(TreeNode root){

    if(root==null){
      return;
    }
    inOrder(root.left);
    System.out.print(root.val+" ");
    inOrder(root.right);
  }
}