package com.suri.datastructure.tree;

import com.suri.companyWise.amazom.TreeNode;

/**
 * Given a binary tree, find size of largest binary search subtree in this
 *  * binary tree.
 *  *
 *  * Traverse tree in post order fashion. Left and right nodes return 4 piece
 *  * of information to root which isBST, size of max BST, min and max in those
 *  * subtree.
 *  * If both left and right subtree are BST and this node data is greater than max
 *  * of left and less than min of right then it returns to above level left size +
 *  * right size + 1 and new min will be min of left side and new max will be max of
 *  * right side.
 *  *
 *  * References:
 *  * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 *  * https://leetcode.com/problems/largest-bst-subtree/
 */
public class LargestBSTinBinaryTree {
    public static void main(String[] args) {

        LargestBST largestBST = new LargestBST();
        largestBST.createTree();
        largestBST.inOrder(largestBST.root);
        System.out.println();
       System.out.println("" + largestBST.largestBST(largestBST.root));

        System.out.println("" + largestBST.largestBSTInBT(largestBST.root).val);

        System.out.println("" + largestBST.maxSize);

    }
}

class LargestBST {
    int maxSize=0;
    TreeNode result =null;

    class MinMax {

        int min;
        int max;
        boolean isBST;
        int size;

        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }


    TreeNode root;

    LargestBST() {
        root = null;
    }

    public int largestBST(TreeNode root) {
        MinMax m = largestBSTInBinaryTree(root);
        System.out.println();
        return m.size;
    }

    public void createTree() {
        this.root = new TreeNode(25);

        TreeNode n1 = new TreeNode(18);
        TreeNode n2 = new TreeNode(50);

        TreeNode n3 = new TreeNode(19);
        TreeNode n4 = new TreeNode(20);
        TreeNode n5 = new TreeNode(35);
        TreeNode n6 = new TreeNode(60);


        TreeNode n7 = new TreeNode(15);
        TreeNode n8 = new TreeNode(18);
        TreeNode n9 = new TreeNode(25);
        TreeNode n10 = new TreeNode(20);
        TreeNode n11 = new TreeNode(40);
        TreeNode n12 = new TreeNode(55);
        TreeNode n13 = new TreeNode(70);

        TreeNode n14 = new TreeNode(25);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n3.right= n7;

        n4.left=n8;
        n4.right=n9;

        n5.left=n10;
        n5.right=n11;

        n6.left=n12;
        n6.right=n13;

        n10.right=n14;

    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.val);
        inOrder(root.right);

    }

    public MinMax largestBSTInBinaryTree(TreeNode root) {

        if (root == null) {
            return new MinMax();
        }

        MinMax left = largestBSTInBinaryTree(root.left);
        MinMax right = largestBSTInBinaryTree(root.right);

        MinMax m = new MinMax();


        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST.
        //Return false and max size of left and right subtree to parent
        if (left.isBST == false || right.isBST == false || (left.max > root.val || right.min <= root.val)) {
            m.isBST = false;
            m.size = Math.max(left.size, right.size);
            return m;
        }


        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = left.size + right.size + 1;

        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left == null ? root.val : left.min;

        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right == null ? root.val : right.max;

        return m;


    }


    TreeNode largestBSTInBT(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = largestBSTInBT(root.left);
        TreeNode right = largestBSTInBT(root.right);

        if (isBST(left, Integer.MIN_VALUE, Integer.MAX_VALUE) && isBST(right, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            int size = size(left) + size(right) + 1;
            if (size > maxSize) {
                maxSize = size;
                result = root;
            }
        }
        return result;
    }

    public boolean isBST(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }

        if(root.val<=min || root.val>=max){
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.left, root.val, max);
    }

    public  int size(TreeNode root){
        if(root==null){
            return 0;
        }
        return size(root.left)+size(root.right)+1;
    }


}