package com.suri.leetcode.medium;

import com.suri.common.Pair;
import com.suri.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given the root of a binary tree, return the maximum width of the given tree.

 The maximum width of a tree is the maximum width among all levels.

 The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

 It is guaranteed that the answer will in the range of a 32-bit signed integer.



 Example 1:


 Input: root = [1,3,2,5,3,null,9]
 Output: 4
 Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 Example 2:


 Input: root = [1,3,2,5,null,null,9,6,null,7]
 Output: 7
 Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 Example 3:


 Input: root = [1,3,2,5]
 Output: 2
 Explanation: The maximum width exists in the second level with length 2 (3,2).




 https://leetcode.com/problems/maximum-width-of-binary-tree
 */
public class Soln_BT_662_Maximum_Width_of_Binary_Tree {
    public static void main(String[] args) {

    }
    public int widthOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        int maxWidth =0;

        queue.add(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int firstIndex = queue.peek().getValue();
            int lastIndex = firstIndex;
            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> pair = queue.remove();
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                lastIndex = index;
                if(node.left!=null){
                    queue.add(new Pair<>(node.left, index*2));
                }
                if(node.right!=null){
                    queue.add(new Pair<>(node.right, index*2+1));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex-firstIndex+1);
        }
        return maxWidth;

    }
}
