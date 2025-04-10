package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

 Return the smallest level x such that the sum of all the values of nodes at level x is maximal.



 Example 1:


 Input: root = [1,7,0,7,-8,null,null]
 Output: 2
 Explanation:
 Level 1 sum = 1.
 Level 2 sum = 7 + 0 = 7.
 Level 3 sum = 7 + -8 = -1.
 So we return the level with the maximum sum which is level 2.
 Example 2:

 Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 Output: 2
 https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
 */
public class Soln_BT_1161_Maximum_Level_Sum_of_a_Binary_Tree {

    public static void main(String[] args) {

    }
    public int maxLevelSum(TreeNode root) {

        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        int maxSum = Integer.MIN_VALUE;
        int result =0;
        int level=0;


        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            level++;
            int currSum=0;
            for(int i=0;i<size; i++){
                TreeNode temp = queue.remove();
                currSum+= temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            if(currSum>maxSum){
                maxSum = currSum;
                result = level;
            }

        }
        return result;
    }
}
