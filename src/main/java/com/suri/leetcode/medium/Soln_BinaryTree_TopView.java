package com.suri.leetcode.medium;




import com.suri.common.Pair;
import com.suri.common.TreeNode;

import java.util.*;

/**
 Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

 1
 /     \
 2       3
 /  \    /   \
 4    5  6   7

 Top view will be: 4 2 1 3 7
 Note: Return nodes from leftmost node to rightmost node.

 Example 1:

 Input:
 1
 /    \
 2      3
 Output: 2 1 3
 Example 2:

 Input:
 10
 /      \
 20        30
 /   \    /    \
 40   60  90    100
 Output: 40 20 10 30 100

 https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 */
public class Soln_BinaryTree_TopView {
    TreeNode root;
    public static void main(String[] args) {

        Soln_BinaryTree_TopView ob  = new Soln_BinaryTree_TopView();
        ob.createTree();
        System.out.println(ob.findTopView(ob.root));

    }

    public static List<Integer> findTopView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair temp = queue.remove();
            int hd = (Integer) temp.value;
            TreeNode node = (TreeNode) temp.key;
            if (map.get(hd) == null) {
                map.put(hd, node.val);
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        for (Integer val : map.values()) {
            result.add(val);
        }
        return result;
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
