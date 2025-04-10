package com.suri.leetcode.easy;

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.



Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105


Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

Intuition

Let's try to solve a simpler problem first. Given a sorted array of integers, find the minimum difference between any two integers in the array. To solve this problem, we don't need to check every pair of integers. Instead, checking the difference between every two consecutive integers would work. This is because the array is sorted. We will make use of this to solve our original problem.

In the original problem, we have some integer values (i.e. node values), and we need to find the minimum difference between any two values. Thus, the original problem is similar to the problem we discussed above if we keep those values in the sorted order.

To get all the node values we can use a graph traversal algorithm like depth-first search (DFS).

In DFS, we use a recursive function to explore nodes as far as possible along each branch. Upon reaching the end of a branch, we backtrack to the next branch and continue exploring.

Once we encounter an unvisited node, we will take one of its neighbor nodes (if exists) as the next node on this branch. Recursively call the function to take the next node as the 'starting node' and solve the subproblem.

If you are new to Depth First Search, please see our Leetcode Explore Card for more information on it!

After gathering all of the node values into a list of integers, we sort the list and compare the difference between every two consecutive integers to determine the minimum difference between the values.

Algorithm

Create a list of integers nodeValues to store the node values.
Perform the DFS traversal over the given binary search tree. We call dfs(root) where dfs is a recursive method that takes TreeNode node as a parameter. We perform the following in this method:
If node is null, return.
Add the current node's value, node.val, in the nodeValues list.
Recursively perform DFS from node.left.
Recursively perform DFS from node.right.
Sort the nodeValues list.
Create an integer variable minDifference and initialize it to infinity.
Iterate over inorderNodes starting from index 1, and for each element at index i, find the difference with the element at index i - 1 and update the variable minDifference accordingly.
Return minDifference.
https://leetcode.com/problems/minimum-absolute-difference-in-bst
 */

import java.util.ArrayList;
import java.util.List;

public class Sol_BT_530_Minimum_Absolute_Difference_in_BST {
    public static void main(String[] args) {

    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        int minimumDiff = Integer.MAX_VALUE;

        inorder(root, list);

        for(int i=1;i<list.size();i++){
            minimumDiff = Math.min(minimumDiff, list.get(i)- list.get(i-1));
        }
        return minimumDiff;

    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }
}
