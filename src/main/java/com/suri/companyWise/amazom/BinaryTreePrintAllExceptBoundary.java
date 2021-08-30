package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class BinaryTreePrintAllExceptBoundary {

  public static void main(String[] args) {

    BinaryTreePrintAllExceptBoundary printAllExceptBoundary = new BinaryTreePrintAllExceptBoundary();

    printAllExceptBoundary.createTree();
    printAllExceptBoundary.inOrder(printAllExceptBoundary.root);
    System.out.println();
    System.out.println(printAllExceptBoundary.printExceptBoundary(printAllExceptBoundary.root));


  }

  TreeNode root;

  public void createTree() {
    this.root = new TreeNode(15);

    TreeNode n1 = new TreeNode(8);
    TreeNode n2 = new TreeNode(7);

    TreeNode n4 = new TreeNode(6);
    TreeNode n5 = new TreeNode(12);
    TreeNode n6 = new TreeNode(16);
    TreeNode n7 = new TreeNode(19);

    TreeNode n8 = new TreeNode(17);
    TreeNode n9 = new TreeNode(13);
    TreeNode n10 = new TreeNode(9);
    TreeNode n11 = new TreeNode(7);
    TreeNode n12 = new TreeNode(11);

    root.left = n1;
    root.right = n2;

    n1.left = n4;
    n1.right = n5;

    n2.left = n6;
    n2.right = n7;

    n4.left = n8;
    n4.right = n9;

    n5.left= n10;
    n5.right=n11;


    n6.right = n12;
  }


  public List<Integer> printExceptBoundary(TreeNode root) {


    List<Integer> exceptBoundaryView = new ArrayList<>();
    if (root == null) {
      return exceptBoundaryView;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.remove();
        if ((i != size - 1) && (i != 0)) {

          if (current.left != null || current.right != null) {
            exceptBoundaryView.add(current.val);
          }
        }

        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }

    }
    return exceptBoundaryView;

  }

  public void inOrder(TreeNode root){

    if(root!=null){
      inOrder(root.left);
      System.out.print(" "+root.val);
      inOrder(root.right);
    }
  }
}