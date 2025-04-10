package com.suri.leetcode.medium;
/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.



Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Soln_graph_323_Number_of_Connected_Components_Undirected_Graph {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{3,4}};
        int n =5;
        System.out.println(countComponents(n, edges));

    }
    public static int countComponents(int n, int[][] edges) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int [] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];


        int component=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                component++;
                doDfs(i, adjacencyList, visited);
            }
        }
        return component;

    }

    public static void doDfs(int start, List<List<Integer>> adjacencyList, boolean visited[]){

        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()){

            int node = stack.pop();

            if(!visited[node]){
                visited[node]= true;
                for(int neighbor: adjacencyList.get(node)){
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
