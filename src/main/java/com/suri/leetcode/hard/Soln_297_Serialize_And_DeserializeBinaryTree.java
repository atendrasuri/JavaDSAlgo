package com.suri.leetcode.hard;

import com.suri.leetcode.medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
https://www.youtube.com/watch?v=-YbXySKJsX8&ab_channel=takeUforward

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []


Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3


Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30

 */

public class Soln_297_Serialize_And_DeserializeBinaryTree {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp==null){
                sb.append("n ");
                continue;
            }
            sb.append(temp.val+" ");
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null){
            return null;
        }

        String value [] = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        queue.add(root);
        for(int i=1;i<value.length;i++){

            TreeNode parent =  queue.poll();

            if(!value[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                parent.left= left;
                queue.add(left);
            }
            i++;
            if(!value[i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                parent.right= right;
                queue.add(right);
            }

        }
        return root;



    }
}
