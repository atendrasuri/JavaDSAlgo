package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/delete-nodes-and-return-forest

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.



Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]


 */
public class Soln_1110_Delete_Nodes_And_Return_Forest {
    public static void main(String[] args) {

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for(int val:to_delete){
            toDeleteSet.add(val);
        }
        List<TreeNode> forest = new ArrayList<>();

        root = processNode(root, toDeleteSet, forest);

        if(root!=null){
            forest.add(root);
        }
        return forest;
    }


    private TreeNode processNode(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest){

        if(node ==null){
            return null;
        }
        node.left = processNode(node.left, toDeleteSet, forest);
        node.right = processNode(node.right, toDeleteSet, forest);

        if(toDeleteSet.contains(node.val)){
            if(node.left!=null){
                forest.add(node.left);
            }
            if(node.right!=null){
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }

    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            TreeNode currentNode = nodesQueue.poll();

            if (currentNode.left != null) {
                nodesQueue.add(currentNode.left);
                // Disconnect the left child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if (currentNode.right != null) {
                nodesQueue.add(currentNode.right);
                // Disconnect the right child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            // If the current node needs to be deleted, add its non-null children to the forest
            if (toDeleteSet.contains(currentNode.val)) {
                if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }
        }

        // Ensure the root is added to the forest if it is not to be deleted
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }

}

/*
Approach 1: Recursion (Postorder Traversal)
Intuition
We mentioned the need to process each node's children before the node itself. One traversal method that aligns with this requirement is postorder traversal. In postorder traversal, we visit the left child, then the right child, and finally the parent node. This sequence ensures that by the time we reach a node, its entire subtree has already been processed, allowing us to safely delete the node if necessary.

In contrast, preorder and inorder traversals do not meet this requirement. In preorder traversal, we visit the parent node before its children, risking deletion of a node before its children are handled, potentially losing subtrees. In inorder traversal, we first visit the left child, then the parent node, and finally the right child, partially processing the subtree before addressing the parent node, which can lead to incomplete handling of nodes and subtree loss.

To solve this problem, we recursively traverse each node's left and right children before processing the node itself. If the current node needs deletion, we check its children. If they are not null, we add them to the forest as new roots. Finally, we delete the current node by returning null to its parent.

Special handling is required for the root node. After processing the entire tree, if the root is not null and hasn't been deleted, it should be added to the forest as well.

Algorithm
Initialization:

Convert the to_delete array to a set for efficient lookups and store it as toDeleteSet.
Create an empty list forest to store the roots of the resulting forest.
Recursive Traversal: Perform a postorder traversal to ensure that we process all descendant nodes before the current node (node):

Recursively call processNode for the left child of node and update the left child with the return value.
Similarly, recursively call processNode for the right child of node and update the right child with the return value.
Node Evaluation:

Check if the current node needs to be deleted by checking if its value exists in the toDeleteSet. If the node needs to be deleted:
If node has a left child that is not null, add the left child to the forest.
If node has a right child that is not null, add the right child to the forest.
Delete the current node and return null to effectively remove the node by not reconnecting it to its parent.
If the node is not to be deleted, return the node itself.

Algorithm
Initialization:

Convert the to_delete array to a set for efficient lookups and store it as toDeleteSet.
Create an empty list forest to store the roots of the resulting forest.
Recursive Traversal: Perform a postorder traversal to ensure that we process all descendant nodes before the current node (node):

Recursively call processNode for the left child of node and update the left child with the return value.
Similarly, recursively call processNode for the right child of node and update the right child with the return value.
Node Evaluation:

Check if the current node needs to be deleted by checking if its value exists in the toDeleteSet. If the node needs to be deleted:
If node has a left child that is not null, add the left child to the forest.
If node has a right child that is not null, add the right child to the forest.
Delete the current node and return null to effectively remove the node by not reconnecting it to its parent.
If the node is not to be deleted, return the node itself.
 */
