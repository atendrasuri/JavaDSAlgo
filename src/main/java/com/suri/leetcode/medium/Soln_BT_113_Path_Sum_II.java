package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
https://leetcode.com/problems/path-sum-ii/description

 */
public class Soln_BT_113_Path_Sum_II {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> results = new ArrayList<>();
        compute(root, targetSum, results, new ArrayList<>());
        return results;
    }

    public void compute(TreeNode root, int targetSum, List<List<Integer>> results, List<Integer> result){

        if(root== null){
            return;
        }

        result.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                results.add(new ArrayList<>(result));
            }
        }
        compute(root.left, targetSum - root.val, results, result);
        compute(root.right, targetSum - root.val, results, result);
        result.remove(result.size()-1);
    }
}
