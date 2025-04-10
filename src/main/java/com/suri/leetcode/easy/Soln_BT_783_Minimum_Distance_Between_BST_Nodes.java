package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.



Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
Approach 1: In-order Traversal with List

Intuition

Let's try to solve a simpler problem first. Given a sorted array of integers, find the minimum difference between any two integers in the array. To solve this problem, we don't need to check every pair of integers; instead, checking the difference between every two consecutive integers would work. This is because the array is sorted; let's say the array is {1, 3, 7, 8.....} if we fix one integer, say 7, then its closest element would either be the element on its left or right, i.e., 3 or 8. Hence, for all elements (except the first one), we will check the difference with the element on its left and find the minimum of all such differences.

fig

In the original problem, we have some integer values (i.e. node values), and we need to find the minimum difference between any two values; thus, the original problem is similar to the problem we discussed above if we keep those values in the sorted order.

We can easily convert the original problem into the above one. The in-order traversal of a binary search tree produces a sorted array. Therefore, we will generate the in-order array of the given tree and then find the minimum difference using the algorithm we just discussed.

Algorithm

Initialize the minDistance to MAX_VALUE possible; this is the variable to store the minimum difference.
Perform an in-order traversal of the given binary search tree and store the nodes in a list inorderNodes.
Iterate over inorderNodes starting from index 1, and for each element at i, find the difference with the element at index i - 1 and update the variable minDistance accordingly.
Return minDistance.

 */
public class Soln_BT_783_Minimum_Distance_Between_BST_Nodes {
    public static void main(String[] args) {

    }
    public int minDiffInBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        int minimumDiff = Integer.MAX_VALUE;

        inorder(root, list);

        for(int i=1;i<list.size(); i++){
            minimumDiff = Math.min(minimumDiff, list.get(i)-list.get(i-1));
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
