package com.suri.companyWise.amazom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * 1. Given a Binary Search Tree (BST) and a range [min, max], remove all keys which are outside the given range. The modified tree should also be BST.
 * 2. Given a Binary Search Tree (BST), print the boundary element in anti-clock wise direction.
 * 3. Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
 * 4. The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
 * 5. Print nodes at k distance from root
 * 6. Write Code to Determine if Two Trees are Identical
 * 7. Find the closest element in Binary Search Tree
 * 8. Print the vertical sum of Binary tree.
 * 9. level Order traversal of the Binary tree
 */
public class BSTQuestions {

    public static void main(String[] args) {

        BST bst = new BST();
        bst.createBST(6);
        bst.createBST(-13);
        bst.createBST(14);
        bst.createBST(-8);
        bst.createBST(15);
        bst.createBST(13);
        bst.createBST(7);
        //bst.printverticalSumBST();

       // bst.display();

        System.out.println("Hello");
        bst.displayLevelOrder();

       /* bst.removeBSTOutsideRange(-10, 13);

        System.out.println(" after removing out of range ");*/

       /*System.out.println(" Print BST in boundary View");
       bst.displayBoundaryView();*/

       /* System.out.println("after mirror");
        bst.displayMirrorImage();*/

        // bst.findHeightBST();
        // bst.findDiameterBST();

        //bst.displayNodesatKdistance(1);
        //bst.printClosestElement(16);


        //  bst.display();
    }
}

class BST {

    class Node {

        int data;
        Node left, right;

        Node(int _data) {
            data = _data;
            left = right = null;
        }
    }

    Node root;

    // added for finding closet node of a given key
    static int min_diff = 999999999;
    static int min_diff_key = -1;

    BST() {
        root = null;
    }


    public void createBST(int data) {

        root = insertNode(root, data);
    }

    public void display() {
        inOrder(root);
    }

    public void removeBSTOutsideRange(int min, int max) {

        root = removeNodesOutsideRange(root, min, max);
    }

    public void displayMirrorImage() {

        root = mirrorImage(root);
    }

    public void displayBoundaryView() {

        printBoundayView(root);
    }


    public void findHeightBST() {
        System.out.println(" Height of BST  " + heightBST(root));
    }

    public void findDiameterBST() {
        System.out.println(" Diameter of BST  " + diameterBST(root));
    }

    public void displayNodesatKdistance(int k) {
        printKDistant(root, k);
    }


    public static void printClosestElement(int k) {

        //findClosestElemnt(root,k);
        System.out.println(" Closest Element of " + k + " is " + min_diff_key);
    }


    public void displayLevelOrder() {


        levelOrder(root);
    }

    /**
     * @param node
     * @param data
     * @return
     */

    public Node insertNode(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        } else if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        }
        return node;
    }


    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(" " + node.data);
            inOrder(node.right);

        }
    }


    /**
     * 1. Given a Binary Search Tree (BST) and a range [min, max], remove all keys which are outside the given range. The modified tree should also be BST.
     *
     * @param root
     * @param min
     * @param max
     * @return
     */

    public Node removeNodesOutsideRange(Node root, int min, int max) {

        // BASE CASE
        if (root == null) {
            return root;
        }
        // FIRST FIX THE LEFT AND
        // RIGHT SUBTREE OF ROOT
        root.left = removeNodesOutsideRange(root.left, min, max);
        root.right = removeNodesOutsideRange(root.right, min, max);

        // NOW FIX THE ROOT. THERE ARE
        // TWO POSSIBLE CASES FOR THE ROOT
        // 1. a) Root's key is smaller than
        // min value(root is not in range)

        if (root.data < min) {

            Node rchild = root.right;
            root = null;
            return rchild;
        }

        // 1. b) Root's key is greater than
        // max value (Root is not in range)
        if (root.data > max) {

            Node lchild = root.left;
            root = null;
            return lchild;
        }

        // 2. Root in range
        return root;
    }


    /**
     * 2. Given a Binary Search Tree (BST), print the boundary element in anti-clock wise direction.
     */

    public void printLeafNode(Node node) {
        if (node != null) {


            printLeafNode(node.left);
            if (node.right == null && node.left == null) {
                System.out.println(" " + node.data);
            }
            printLeafNode(node.right);
        }
    }

    // print BoundaryLeft

    public void printBoundayLeft(Node node) {
        if (node != null) {

            if (node.left != null) {
                System.out.println(" " + node.data);
                printBoundayLeft(node.left);
            } else if (node.right != null) {
                System.out.println(" " + node.data);
                printBoundayLeft(node.right);
            }

        }
    }

    /*
       print Boundary Right
     */

    public void printBoundaryRight(Node node) {
        if (node != null) {

            if (node.right != null) {
                printBoundaryRight(node.right);
                System.out.println(" " + node.data);
            } else if (node.left != null) {
                printBoundaryRight(node.left);
                System.out.println(" " + node.data);
            }
        }
    }


    public void printBoundayView(Node node) {

        if (node != null) {
            System.out.println("  " + node.data);
            printBoundayLeft(node.left);
            printLeafNode(node.left);
            printLeafNode(node.right);
            printBoundaryRight(node.right);
        }
    }

    /**
     * 3. Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
     */

    public Node mirrorImage(Node node) {

        if (node == null) {
            return node;
        }

        Node left = mirrorImage(node.left);
        Node right = mirrorImage(node.right);

        node.right = left;
        node.left = right;
        return node;
    }


    /**
     * 4. The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
     * The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of
     * length nine, but no path longer than nine nodes).
     */

    public int diameterBST(Node node) {

        if (node == null) {
            return 0;
        }

        int ldiameter = diameterBST(node.left);
        int rdiameter = diameterBST(node.right);

        int lheight = heightBST(node.left);
        int rheight = heightBST(node.right);

        return Math.max((lheight + rheight + 1), Math.max(ldiameter, rdiameter));

    }

    public int heightBST(Node node) {
        if (node == null) {
            return 0;
        }

        int d = node.data;
        int lheight = heightBST(node.left);

        int d1 = node.data;
        int rheight = heightBST(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    /**
     * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
     */

    public void printKDistant(Node root, int k) {

        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.data);
            return;
        } else {
            printKDistant(root.left, k - 1);
            printKDistant(root.right, k - 1);
        }

    }

    /**
     * Two trees are identical when they have same data and arrangement of data is also same.
     * To identify if two trees are identical, we need to traverse both trees simultaneously, and while traversing
     * we need to compare data and children of the trees.
     */


    public boolean isIdentical(Node root1, Node root2) {


        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return root1.data == root2.data && isIdentical (root1.left, root2.left) && isIdentical(root1.right,root2.right);
        }

        return false;
    }

    /**
     * Find the closest element in Binary Search Tree
     * Given a binary search tree and a target node K.
     * The task is to find the node with minimum absolute difference with given target value K
     */

    public static void findClosestElemnt(Node node, int k) {
        if (node == null) {
            return;
        }
        if (node.data == k) {
            min_diff_key = node.data;
            return;
        }

        // update min_diff and min_diff_key by checking
        // current node value
        if (min_diff > Math.abs(node.data - k)) {
            min_diff = Math.abs(node.data - k);
            min_diff_key = node.data;

        }

        // if k is less than ptr.key then move in
        // left subtree else in right subtree

        if (k < node.data) {
            findClosestElemnt(node.left, k);
        } else {
            findClosestElemnt(node.right, k);
        }

    }

    /**
     * Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines.
     */

    public void printverticalSumBST() {

        Map<Integer, Integer> hm = new HashMap<>();
        findVerticalSumBSTUtil(root, 0, hm);

        for (Map.Entry m : hm.entrySet()) {

            System.out.println("Vertical line " + m.getKey() + " and Sum =" + m.getValue());

        }
    }

    public void findVerticalSumBSTUtil(Node root, int hd, Map<Integer, Integer> hm) {


        if (root == null) {
            return;
        }
        findVerticalSumBSTUtil(root.left, hd - 1, hm);

        int oldSum = hm.get(hd) == null ? 0 : hm.get(hd);
        hm.put(hd, oldSum + root.data);

        findVerticalSumBSTUtil(root.right, hd + 1, hm);
    }


    /**
     * level Order traversal of the Binary tree
     */


    public void levelOrder(Node root) {


        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            Node temp = q.poll();
            if (temp != null) {
                System.out.print(" " + temp.data);
            }
            if(null!=temp.left) {
                q.add(temp.left);
            }
            if(null!=temp.right) {
                q.add(temp.right);
            }
            if (temp == null) {
                System.out.println(" level");
                q.add(null);
            }

        }


    }
}