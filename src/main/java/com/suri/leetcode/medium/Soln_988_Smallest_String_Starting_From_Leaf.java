package com.suri.leetcode.medium;

import com.suri.common.Pair;
import com.suri.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.



Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"
Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"
Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
https://leetcode.com/problems/smallest-string-starting-from-leaf
 */
public class Soln_988_Smallest_String_Starting_From_Leaf {
    public static void main(String[] args) {

    }

    public static String smallestFromLeaf(TreeNode root) {

        String smallestString = "";
        Queue<Pair<TreeNode, String>> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Pair<>(root, String.valueOf((char)(root.val+'a'))));
        while(!nodeQueue.isEmpty()){

            Pair<TreeNode, String> pair = nodeQueue.remove();

            TreeNode node = pair.key;
            String currentString = pair.value;
            if(node.left== null && node.right==null){
                if(smallestString.isEmpty()){
                    smallestString = currentString;
                }else{
                    smallestString = currentString.compareTo(smallestString)<0 ? currentString:smallestString;
                }
            }

            if(node.left!=null){
                nodeQueue.add(new Pair(node.left, (char)(node.left.val+'a') + currentString));
            }
            if(node.right!=null){
                nodeQueue.add(new Pair(node.right, (char)(node.right.val+'a')+currentString));
            }
        }
        return smallestString;
    }
}
