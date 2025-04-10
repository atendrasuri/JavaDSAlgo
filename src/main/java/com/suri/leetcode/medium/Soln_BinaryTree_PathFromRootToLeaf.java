package com.suri.leetcode.medium;

import com.suri.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given the root of a binary tree, return all paths from the root node to every leaf node in the binary tree.

 Input:

 1
 /   \
 /		 \
 2		  3
 /  \		 /  \
 /	  \		/	 \
 4	   5   6	  7
 /		   \
 /			\
 8			 9

 Output: {[1, 2, 4], [1, 2, 5], [1, 3, 6, 8], [1, 3, 7, 9]}

 Explanation: The binary tree has four root-to-leaf paths:

 1 —> 2 —> 4
 1 —> 2 —> 5
 1 —> 3 —> 6 —> 8
 1 —> 3 —> 7 —> 9
 https://techiedelight.com/practice/?problem=RootToLeafPathsInBinaryTree
 */

public class Soln_BinaryTree_PathFromRootToLeaf {
    TreeNode root;
    public static void main(String[] args) {

        Soln_BinaryTree_PathFromRootToLeaf ob  = new Soln_BinaryTree_PathFromRootToLeaf();
        ob.createTree();
        System.out.println(ob.findRootToLeafPaths(ob.root));

    }
    public static Set<List<Integer>> findRootToLeafPaths(TreeNode root)
    {
        Set<List<Integer>> paths = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        findRootToLeafPaths(root, paths, list);
        return paths;
    }

    public static void findRootToLeafPaths(TreeNode root, Set<List<Integer>> paths, List<Integer> list){

        if(root == null){
            return ;
        }

        list.add(root.val);

        if(root.left == null && root.right == null){
            paths.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        findRootToLeafPaths(root.left, paths, list);
        findRootToLeafPaths(root.right, paths, list);
        list.remove(list.size()-1);



    }

    public void createTree() {
        this.root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(9);
        root.left = n1;
        root.right = n2;
        n1.left=n3;
        n1.right=n4;
        n2.left = n5;
        n2.right = n6;

        n6.left= n8;
        n5.left=n7;

    }
}
