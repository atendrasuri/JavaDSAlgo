package com.suri.leetcode.medium;
/*

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
https://leetcode.com/problems/find-largest-value-in-each-tree-row
 */

import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Soln_BT_515_Find_Largest_Value_in_Each_Tree_Row {
    public static void main(String[] args) {

    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max_value = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                max_value = Math.max(max_value, temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            result.add(max_value);
        }
        return result;
    }
}
