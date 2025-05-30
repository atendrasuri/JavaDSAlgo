package com.suri.datastructure.tree;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.locks.Lock;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/11/18
 * @Description: (Overwrite)
 * Given below is a tree. The task is to print the  Level Order Traversal of the given tree
 */
public class PrintLevelOrder {


    public static void main(String[] args) {

        LevelBinaryTree levelBinaryTree = new LevelBinaryTree();

        levelBinaryTree.createTree();
        //levelBinaryTree.inOrder(levelBinaryTree.root);
        System.out.println();
        //levelBinaryTree.levelOrderPrint(levelBinaryTree.root);
        //levelBinaryTree.levelOrderPrintLevelByLevel(levelBinaryTree.root);
        List<List<Integer>> result = levelBinaryTree.levelOrder(levelBinaryTree.root);
        for(List<Integer> l:result){
            System.out.println(l);
        }


    }
}

class LevelBinaryTree {
    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;


    LevelBinaryTree() {
        root = null;
    }

    public void createTree() {
        this.root = new Node(1);

        Node n1 = new Node(2);
        Node n2 = new Node(3);

        /*Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);*/

        root.left = n1;
        root.right = n2;

        /*n1.left = n4;
        n1.right = n5;

        n2.left = n6;
        n2.right = n7;*/


    }

    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }

    void levelOrderPrint(Node root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }


    void levelOrderPrintLevelByLevel(Node node) {
        if (node == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();


        int levelNodes = 0;

        queue.add(node);

        while (!queue.isEmpty()) {

            levelNodes = queue.size();
            int t=levelNodes;

            while (levelNodes > 0) {
                Node temp = queue.remove();

                if(levelNodes==1) {
                    System.out.println("  " + temp.data);
                }
                if(levelNodes==t && levelNodes!=1){
                    System.out.print("  " + temp.data);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                levelNodes--;
            }

        }

    }

    /**
     * another approach
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder(Node root) {


        List<List<Integer>> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size=queue.size();
            List<Integer> currentLevel = new ArrayList<>();;
            for(int i=0;i<size;i++){
                Node current =  queue.removeFirst();
                if(current!=null){
                    currentLevel.add(current.data);
                }

                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;

    }


}

