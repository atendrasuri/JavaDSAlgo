package com.suri.leetcode.medium;


import com.suri.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
https://leetcode.com/problems/path-sum-iii
 */
public class Soln_BT_437_Path_Sum_III {

    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum){

        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0l, 1);
        return dfs(root, targetSum, 0l, prefixSum);
    }

    public int dfs(TreeNode root, int targetSum, long currentSum, Map<Long, Integer> prefixSum){

        if(root==null){
            return 0;
        }
        currentSum = currentSum+ root.val;

        int count = prefixSum.getOrDefault(currentSum-targetSum, 0);

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0)+1);

        count+= dfs(root.left, targetSum, currentSum, prefixSum);
        count+= dfs(root.right, targetSum, currentSum, prefixSum);

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0)-1);

        return count;
    }
}

/*
Complexity Analysis
Time complexity: O(N), where N is a number of nodes. During preorder traversal, each node is visited once.

Space complexity: up to O(N) to keep the hashmap of prefix sums, where N is a number of nodes.
 */

/*

Approach 1: Prefix Sum
Intuition
Now let's reuse the same algorithm and the same code for the case of the binary tree.

There is just one thing that is particular for the binary tree. There are two ways to go forward - to the left and to the right. To keep parent->child direction, we shouldn't blend prefix sums from the left and right subtrees in one hashmap.

Algorithm
Let's initialize tree paths counter count = 0, and the hashmap h "prefix sum -> how many times was it seen so far".

One could parse the tree using recursive preorder traversal: node -> left -> right: preorder(node: TreeNode, curr_sum: int) -> None. This function takes two arguments: a tree node and a prefix sum before that node. To start the recursion chain, one should call preorder(root, 0).

The first thing is to update the current prefix sum by adding the value of the current node: curr_sum += node.val.

Now one could update the counter. One should consider two situations.

In situation 1, the tree path with the target sum starts from the root. That means the current prefix sum is equal to the target sum curr_sum == k, so one should increase the counter by 1: count += 1.

In situation 2, the tree path with the target sum starts somewhere downwards. That means we should add to the counter the number of times we have seen the prefix sum curr_sum - target so far: count += h[curr_sum - target].

The logic is simple: the current prefix sum is curr_sum, and several elements before the prefix sum was curr_sum - target. All the elements in between sum up to curr_sum - (curr_sum - target) = target.

Now it's time to update the hashmap: h[curr_sum] += 1.

Let's parse left and right subtrees: preorder(node.left, curr_sum), preorder(node.right, curr_sum).

Now the current subtree is processed. It's time to remove the current prefix sum from the hashmap, in order not to blend the parallel subtrees: h[curr_sum] -= 1.

Now the preorder traversal is done, and the counter is updated. Return it.
 */
