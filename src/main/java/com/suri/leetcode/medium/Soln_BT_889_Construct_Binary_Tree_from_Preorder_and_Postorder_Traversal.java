package com.suri.leetcode.medium;
/*
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.



Example 1:


Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]

 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 */

import com.suri.common.TreeNode;

public class Soln_BT_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
    public static void main(String[] args) {

    }
    class Solution {

        int preIndex =0;
        int postIndex =0;
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return constructTree(preorder, postorder);
        }

        private TreeNode constructTree(int[] preorder, int[] postorder){

            TreeNode root = new TreeNode(preorder[preIndex++]);

            // Recursively construct the left subtree if the root is not the last of
            // its subtree
            if(root.val!= postorder[postIndex] ){
                root.left = constructTree(preorder, postorder);
            }

            // Recursively construct the right subtree if the root is still not the
            // last of its subtree
            if(root.val != postorder[postIndex] ){
                root.right = constructTree(preorder, postorder);
            }

            // Mark this node and its subtree as fully processed
            postIndex++;
            return root;
        }
    }
}
/*
Define the recursive functionconstructTree(preIndex, postIndex, preorder, postorder):
Create a new noderootwith valuepreorder[preIndex].
IncrementpreIndexby1to mark this node as created.
If the value of root is not equal topostorder[postIndex], meaning that the node has children:
Recursively construct the left subtree using:constructTree(preIndex, postIndex, preorder, postorder).
If the value ofrootis still not equal topostorder[postIndex], the node has a right child as well:
Construct the right subtree using:constructTree(preIndex, postIndex, preorder, postorder).
IncrementpostIndexby1to mark this node and its subtree as processed.
Returnroot.
In the mainconstructFromPrePostfunction:
Initialize two variables,preIndex = 0,postIndex = 0.
Create the tree usingconstructTree(preIndex, postIndex, preorder, postorder)and return it.

 */

/*
Complexity Analysis
Letnbe the size of the traversal arrays.

Time complexity:O(n)
 */
