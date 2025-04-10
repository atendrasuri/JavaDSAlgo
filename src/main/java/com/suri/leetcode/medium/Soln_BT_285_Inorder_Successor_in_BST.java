package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

/*
Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

The successor of a node p is the node with the smallest key greater than p.val.



Example 1:


Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:


Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
 https://leetcode.com/problems/inorder-successor-in-bst/description/

Algorithm

We define two class variables for this algorithm: previous and inorderSuccessorNode. The previous variable will only be used when handling the second case as previously explained and the inorderSuccessorNode will ultimately contain the result to be returned.

Inside the function inorderSuccessor, we first check which of the two cases we need to handle. For that, we simply check for the presence of the right child.

1. The right child exists

In this case, we assign the right child to a node called leftmost and we iterate until we reach a node (leftmost) that doesn't have a left child. We iteratively assign leftmost = leftmost.left and that's how we will get the leftmost node in the subtree.

2. The right child does not exist

As mentioned before, this case is trickier to handle. For this, we define another function called inorderCase2 and we will pass it a node and the node p.
We perform simple inorder traversal and hence, we first recurse on the left child of the node.
Then, when the recursion returns, we check if the class variable previous is equal to the node p. If that is the case, then it means p is the inorder predecessor of node or in other words, the node is the inorder successor of the node p and we return from that point onwards. We assign inorderSuccessorNode to node and return from this function.

Finally, we return the inorderSuccessorNode as our result.
 */
public class Soln_BT_285_Inorder_Successor_in_BST {
    public static void main(String[] args) {

    }
}
class Solution {

    private TreeNode previous;
    private TreeNode inorderSuccessorNode;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.

        if(p.right!=null){

            TreeNode leftmost = p.right;
            while(leftmost.left!=null){
                leftmost = leftmost.left;
            }
            inorderSuccessorNode = leftmost;

        }else{
            // Case 2: We need to perform the standard in order to traversal and keep track of the previous node.
            inorderCase2(root, p);
        }
        return inorderSuccessorNode;

    }

    private void inorderCase2(TreeNode node, TreeNode p){
        if(node==null){
            return;
        }
        inorderCase2(node.left, p);
        if(previous ==p && inorderSuccessorNode==null){
            inorderSuccessorNode = node;
            return;
        }
        previous = node;
        inorderCase2(node.right, p);
    }
}
