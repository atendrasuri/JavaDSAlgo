package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 *
 *
 *
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 */
public class Soln_1448_Count_Good_Nodes_in_Binary_Tree {
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {

        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        if (root.val >= max) {
            cnt++;
        }
        max = Math.max(root.val, max);
        return cnt + goodNodes(root.left, max) + goodNodes(root.right, max);

    }

    public int goodNodes1(TreeNode root, int maxval) {

        if(root==null){
            return 0;
        }

        int cntGoodNode = root.val>=maxval?1:0;

        maxval = Math.max(root.val, maxval);

        cntGoodNode+= goodNodes1(root.left, maxval);
        cntGoodNode+= goodNodes1(root.right, maxval);
        return cntGoodNode;
    }
}
