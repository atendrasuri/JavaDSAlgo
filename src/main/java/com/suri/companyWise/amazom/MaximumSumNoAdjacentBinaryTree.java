package com.suri.companyWise.amazom;

import com.suri.common.TreeNode;

import java.util.HashMap;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MaximumSumNoAdjacentBinaryTree {
  public static void main(String[] args) {

    NoAdjacentBinaryTree noAdjacentBinaryTree = new NoAdjacentBinaryTree();
    noAdjacentBinaryTree.createTree();
    System.out.println(noAdjacentBinaryTree.getMaximumSumNoAdjacentBinaryTree(noAdjacentBinaryTree.root, new HashMap<>()));

    NoAdjacentBinaryTree.Pair result= noAdjacentBinaryTree.getMaxSum(noAdjacentBinaryTree.root);

    System.out.println(Math.max(result.incl,result.excl));

  }


}

class NoAdjacentBinaryTree {

  class Pair {
    int incl;
    int excl;
    Pair(int incl,int excl){
      this.incl=incl;
      this.excl=excl;
    }
  }

  TreeNode root;

  public void createTree() {
    this.root = new TreeNode(1);

    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(3);

    TreeNode n4 = new TreeNode(1);
    TreeNode n5 = new TreeNode(4);
    TreeNode n6 = new TreeNode(5);


    root.left = n1;
    root.right = n2;

    n1.left = n4;

    n2.left = n5;
    n2.right = n6;


  }

  public int getMaximumSumNoAdjacentBinaryTree(TreeNode node, HashMap<TreeNode, Integer> map) {

    if (node == null) {
      return 0;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }

    int incl = node.val + sumOfGrandChildren(node, map);

    int excl = getMaximumSumNoAdjacentBinaryTree(node.left, map) + getMaximumSumNoAdjacentBinaryTree(node.right, map);

    map.put(node, Math.max(incl, excl));

    return map.get(node);
  }

  public int sumOfGrandChildren(TreeNode node, HashMap<TreeNode, Integer> map) {

    if (node == null) {
      return 0;
    }
    int sum = 0;
    if (node.left != null) {
      sum += getMaximumSumNoAdjacentBinaryTree(node.left.left, map) + getMaximumSumNoAdjacentBinaryTree(node.left.right, map);

    }
    if (node.right != null) {
      sum += getMaximumSumNoAdjacentBinaryTree(node.right.left, map) + getMaximumSumNoAdjacentBinaryTree(node.right.right, map);
    }


    return sum;
  }

  public Pair getMaxSum(TreeNode node) {

    if (node == null) {
      Pair sum = new Pair(0,0);
      return sum;
    }
    Pair leftSum = getMaxSum(node.left);
    Pair rightSum = getMaxSum(node.right);
    Pair sum = new Pair(0,0);
    sum.incl =  leftSum.excl+rightSum.excl+node.val;
    sum.excl = Math.max(leftSum.incl,leftSum.excl)+Math.max(rightSum.incl,rightSum.excl);
    return sum;
  }
}