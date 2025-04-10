package com.suri.leetcode.medium;




import com.suri.common.Pair;
import com.suri.common.TreeNode;

import java.util.*;

/**

 Given a binary tree, print the bottom view from left to right.
 A node is included in bottom view if it can be seen when we look at the tree from bottom.

 20
 /    \
 8       22
 /   \        \
 5      3       25
 /   \
 10    14

 For the above tree, the bottom view is 5 10 3 14 25.
 If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

 20
 /    \
 8       22
 /   \     /   \
 5      3 4     25
 /    \
 10       14

 For the above tree the output should be 5 10 4 14 25.
 Example 1:

 Input:
 1
 /   \
 3     2
 Output: 3 1 2
 Explanation:
 First case represents a tree with 3 nodes
 and 2 edges where root is 1, left child of
 1 is 3 and right child of 1 is 2.

 Example 2:

 Input:
 10
 /    \
 20    30
 /  \
 40   60
 Output: 40 20 60 30
 https://www.geeksforgeeks.org/bottom-view-binary-tree/
 */
public class Soln_BinaryTree_BottomView {
    TreeNode root;
    public static void main(String[] args) {

        Soln_BinaryTree_BottomView ob  = new Soln_BinaryTree_BottomView();
        ob.createTree();
        System.out.println(ob.findBottomView(ob.root));

    }

    public static List<Integer> findBottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair temp = queue.remove();
            int hd = (Integer)temp.value;
            TreeNode node = (TreeNode) temp.key;
            //keep putting in map, in last it will keep only last value of that vertical line
            map.put(hd, node.val);

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
