package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class Soln_BT_102_Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>  result = new ArrayList<>();

        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){

                TreeNode temp = queue.remove();
                list.add(temp.val);

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            result.add(list);
        }
        return result;

    }
}
