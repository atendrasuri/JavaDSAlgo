package com.suri.datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DFSTest {
  public static void main(String[] args) {

    int nos = 5;
    boolean vis[] = new boolean[nos];

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(0);
    list1.add(1);
    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(0);
    list2.add(2);
    ArrayList<Integer> list3 = new ArrayList<>();
    list3.add(0);
    list3.add(3);
    ArrayList<Integer> list4 = new ArrayList<>();
    list4.add(2);
    list4.add(4);

    list.add(list1);
    list.add(list2);
    list.add(list3);
    list.add(list4);
    System.out.println(list);

    //dfs(0, list, vis);
    dfsRecursive(0, list, vis);

  }

  public static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {


    Stack<Integer> stack = new Stack<>();
    stack.push(src);

    while (!stack.isEmpty()) {
      int n = stack.pop();

      if (vis[n])
        continue;

      System.out.print(n + " ");
      vis[n] = true;

      for (int i = 0; i < list.get(n).size(); i++) {

        int temp = list.get(n).get(i);
        if (!vis[temp]) {
          stack.push(temp);
        }

      }
    }
  }
  public static void dfsRecursive(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]){

    vis[src]=true;

    System.out.print(src+" ");

    for(int i=0;i<list.get(src).size();i++){

      if(!vis[list.get(src).get(i)]){
        dfsRecursive(list.get(src).get(i),list,vis);
      }
    }
  }

}

