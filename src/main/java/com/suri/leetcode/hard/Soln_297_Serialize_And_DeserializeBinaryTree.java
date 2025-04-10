package com.suri.leetcode.hard;

import com.suri.common.TreeNode;

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

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode temp = queue.poll();
            if(temp==null){
                sb.append("N,");
            }else{
                sb.append(temp.val).append(",");
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String val[] = data.split(",");

        if(val[0].equals("N")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index =1;

        while(!queue.isEmpty()){

            TreeNode temp = queue.poll();

            if(!val[index].equals("N")){
                temp.left = new TreeNode(Integer.parseInt(val[index]));
                queue.add(temp.left);
            }
            index++;

            if(!val[index].equals("N")){
                temp.right = new TreeNode(Integer.parseInt(val[index]));
                queue.add(temp.right);
            }
            index++;
        }
        return root;

    }
}
