package com.suri.leetcode.medium;

import com.suri.leetcode.easy.Soln_543_DiameterofBinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Input:
          20
        /    \
      8       22
    /   \
   4    12
       /   \
      10    14
Target Node = 8
K = 2
Output: 10 14 22
Explanation: The three nodes at distance 2
from node 8 are 10, 14, 22.


Example 2:

Input:
         20
       /    \
      7      24
    /   \
   4     3
        /
       1
Target Node = 7
K = 2
Output: 1 24
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree
https://www.youtube.com/watch?v=B89In5BctFA&t=203s&ab_channel=Pepcoding
 */
public class Soln_863_BinaryTree_AllNodesDistanceK {
    TreeNode root;
    public static void main(String[] args) {

        Soln_863_BinaryTree_AllNodesDistanceK ob  = new Soln_863_BinaryTree_AllNodesDistanceK();
        ob.createTree();

        System.out.println(ob.distanceK(ob.root, ob.root.right.left, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> nodeToRootPath = new ArrayList<>();
        nodeToRoot(root, target, nodeToRootPath);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nodeToRootPath.size(); i++) {
            kLevelDown(nodeToRootPath.get(i), i == 0 ? null : nodeToRootPath.get(i - 1), k - i, result);
        }
        return result;
    }


    public boolean nodeToRoot(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            path.add(root);
            return true;
        }
        boolean fic = nodeToRoot(root.left, target, path);
        if (fic) {
            path.add(root);
            return true;
        }
        boolean fir = nodeToRoot(root.right, target, path);
        if (fir) {
            path.add(root);
            return true;
        }
        return false;
    }

    public void kLevelDown(TreeNode root, TreeNode blocker, int k, List<Integer> result) {

        if (root == null || k < 0 || root == blocker) {
            return;
        }
        if (k == 0) {
            result.add(root.val);
        }
        kLevelDown(root.left, blocker, k - 1, result);

        kLevelDown(root.right, blocker, k - 1, result);
    }


    public void createTree() {
        this.root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

    }
}
