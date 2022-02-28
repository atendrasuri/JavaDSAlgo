package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryTraversalBT {

    TreeNode root;
    public static void main(String[] args) {

        BoundaryTraversalBT obj = new BoundaryTraversalBT();

        obj.root = new TreeNode(20);
        obj.root.left= new TreeNode(8);
        obj.root.left.left= new TreeNode(4);
        obj.root.right= new TreeNode(22);
        obj.root.right.right= new TreeNode(25);

        obj.root.left.right= new TreeNode(12);

        obj.root.left.right.left=new TreeNode(10);
        obj.root.left.right.right=new TreeNode(14);
        System.out.println(obj.boundaryTraversal(obj.root));

    }


    public static List<Integer> boundaryTraversal(TreeNode root){
        List<Integer> finalresult = new ArrayList<>();

        finalresult.add(root.val);

        List<Integer> left = leftView(root.left);

        finalresult.addAll(left);
        List<Integer> right = rightView(root.right);
        for(int i = right.size()-1;i>=0;i--){
            finalresult.add(right.get(i));
        }

        return finalresult;
    }


    public static List<Integer> leftView(TreeNode root){
        List<Integer> leftResult = new ArrayList<>();
        if(root== null){
            return leftResult;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                if(i==0){
                    leftResult.add(temp.val) ;
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return leftResult;
    }


    public static List<Integer> rightView(TreeNode root){
        List<Integer> rightResult = new ArrayList<>();
        if(root== null){
            return rightResult;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                if(i==size-1){
                    rightResult.add(temp.val) ;
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return rightResult;
    }
}
