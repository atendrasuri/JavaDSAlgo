package com.suri.companyWise.amazom;

import com.suri.common.TreeNode;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
  public static void main(String[] args) {

    SolutionHouseRobberIII solutionHouseRobberIII = new SolutionHouseRobberIII();
    solutionHouseRobberIII.createTree();
    System.out.println(solutionHouseRobberIII.rob(solutionHouseRobberIII.root));

  }
}

class SolutionHouseRobberIII {

  class Pair {
    int incl;
    int excl;

    Pair(int incl, int excl) {
      this.incl = incl;
      this.excl = excl;

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


  public int rob(TreeNode root) {

    if (root == null) {
      return 0;
    }

    Pair result = robSum(root);
    return Math.max(result.incl, result.excl);

  }

  public Pair robSum(TreeNode root) {

    if (root == null) {
      Pair sum = new Pair(0, 0);
      return sum;
    }

    Pair leftSum = robSum(root.left);
    Pair rightSum = robSum(root.right);

    Pair sum = new Pair(0, 0);

    sum.incl = leftSum.excl + rightSum.excl + root.val;

    sum.excl = Math.max(leftSum.incl, leftSum.excl) + Math.max(rightSum.incl, rightSum.excl);

    return sum;


  }


}