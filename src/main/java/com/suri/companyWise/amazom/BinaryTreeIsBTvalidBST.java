package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/02/19
 * @Description: (Overwrite)
 * Check whether a Binary Tree is Binary search Tree or not?
 * @History:
 */
public class BinaryTreeIsBTvalidBST {

    public static void main(String[] args) {
        BT bt = new BT();
        bt.insertData(15);
        bt.insertData(10);
        bt.insertData(20);
        bt.insertData(8);
        bt.insertData(12);
        bt.insertData(16);
        bt.insertData(25);
        bt.swap(bt.root);
        bt.display();
        bt.isValidBSTorNot();
    }
}


class BT {

    class Node {

        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    Node root;

    BT() {
        root = null;
    }


    public void insertData(int data) {

        root = insertNode(root, data);
    }

    public void display() {
        inOrder(root);
    }

    public void isValidBSTorNot(){

        boolean result = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        if(result){
            System.out.println(" Given Binary Tree is Valid BST");
        }
        else{
            System.out.println(" Given Binary Tree is not Valid BST");
        }
    }

    Node insertNode(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }

        return root;
    }

    public void inOrder(Node root) {


        if (root != null) {
            inOrder(root.left);
            System.out.println("  " + root.data);
            inOrder(root.right);
        }
    }


    public void swap(Node root){
        Node left = root.left;
        root.left = root.right;
        root.right= left;

    }

    public boolean isValidBST(Node root, int min, int max ){

        if(root==null){
            return true;
        }
        if(root.data<min || root.data>max){
            return false;
        }
        if(isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max)){
            return true;
        }
        return false;
    }

}