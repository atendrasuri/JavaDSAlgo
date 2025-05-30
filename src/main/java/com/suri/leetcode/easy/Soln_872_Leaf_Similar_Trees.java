package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
https://leetcode.com/problems/leaf-similar-trees
 */
public class Soln_872_Leaf_Similar_Trees {
    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> list){
        if(node==null){
            return ;
        }
        if(node.left==null && node.right==null){
            list.add(node.val);
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
