package com.suri.companyWise.amazom;


import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
  public static void main(String[] args) {
    PathSumII pathSumII = new PathSumII();
    pathSumII.createTree();
    System.out.println(pathSumII.pathSum(pathSumII.root, 22));


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

  public List<List<Integer>> pathSum(TreeNode root, int sum) {

    List<List<Integer>> paths = new ArrayList<>();

    findPaths(root, new ArrayList<Integer>(), sum, paths);
    return paths;

  }

  public void findPaths(TreeNode root, ArrayList<Integer> path,
                        int sum, List<List<Integer>> paths) {
    if (root == null) {
      return;
    }

    path.add(root.val);
    if (root.val == sum && root.left == null && root.right == null) {
      paths.add(path);
      return;
    }
    findPaths(root.left, new ArrayList<Integer>(path), sum - root.val, paths);
    findPaths(root.right, new ArrayList<Integer>(path), sum - root.val, paths);


  }
}

