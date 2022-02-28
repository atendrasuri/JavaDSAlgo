package com.suri.datastructure.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * Given a binary tree, print all root-to-leaf paths
 * For the below example tree, all root-to-leaf paths are:
    6 5 #
    6 13 8 9 #
    6 13 16 15 14 #
    6 13 16 20 21 #
 * @History:
 */
public class RootToLeafAllPath {

    public static void main(String[] args) {

        BTRootToLeaf bst = new BTRootToLeaf();
        bst.insertNode(6);bst.insertNode(13);bst.insertNode(16);bst.insertNode(20);bst.insertNode(21);bst.insertNode(15);
        bst.insertNode(5);bst.insertNode(14);bst.insertNode(8);bst.insertNode(9);
        bst.printRootToLeaf();

    }
}


class BTRootToLeaf{

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data= data;
        }
    }

    Node root;
    //String path;

    BTRootToLeaf(){
        root=null;
    }

    public void insertNode(int data){
        root= insert(root, data);
    }

    public void display(){

        //  inOrder(root);
    }

    public void printRootToLeaf(){

        ArrayList<Integer> list = new ArrayList<>();
        //rootToLeafPath(root,list );

        Set<List<Integer>> paths = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        findRootToLeafPaths(root, paths, list1);
        System.out.println(paths);
    }



    public Node insert(Node node, int data){

        if(node==null){
            node= new Node(data);
            return node;
        }

        if(data>node.data){
            node.right= insert(node.right,data);
        }
        else if(data<node.data){
            node.left= insert(node.left,data);
        }
        return node;

    }

    public void inOrder(Node root){
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }


    public void rootToLeafPath(Node root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }
        list.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(list);
            list.remove(list.size()-1);
            return;
        }
        /**
         *
         * commented line is another approach
         */
        rootToLeafPath(root.left, list);
        rootToLeafPath(root.right, list);
        //rootToLeafPath(root.left, new ArrayList<>(list));
        //rootToLeafPath(root.right, new ArrayList<>(list));
        list.remove(list.size()-1);
    }

    public static void findRootToLeafPaths(Node root, Set<List<Integer>> paths, List<Integer> list){
        if(root == null){
            return ;
        }
        list.add(root.data);
        if(root.left == null && root.right == null){
            paths.add(new ArrayList<>(list));
           list.remove(list.size()-1);
            return;
        }
        findRootToLeafPaths(root.left, paths, list);
        findRootToLeafPaths(root.right, paths, list);
        list.remove(list.size()-1);
    }

    public void printPath(ArrayList<Integer>list){

        list.forEach(System.out::print);
        System.out.println("#");
    }
}