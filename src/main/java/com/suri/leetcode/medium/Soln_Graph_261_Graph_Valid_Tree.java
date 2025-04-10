package com.suri.leetcode.medium;

import java.util.*;

/*
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.



Example 1:


Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
https://leetcode.com/problems/graph-valid-tree/description/
https://leetcode.com/problems/graph-valid-tree/editorial/

Recall that a graph, G, is a tree iff the following two conditions are met:

1. G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
2. G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.
 */
public class Soln_Graph_261_Graph_Valid_Tree {

    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int n=5;
        System.out.println(validTree(n, edges));

    }
    public static boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();

        parent.put(0, -1);

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        while(!stack.isEmpty()){

            int node = stack.pop();
            // Take one off to visit.
            // Check for unseen neighbours of this node:

            for(int neighbor : adjacencyList.get(node)){
                // Don't look at the trivial cycle.
                if(parent.get(node)==neighbor){
                    continue;
                }

                // Check if we've already seen this node.
                if(parent.containsKey(neighbor)){
                    return false; // There must be a cycle.
                }
                // Otherwise, put this neighbour onto stack
                // and record that it has been seen.
                stack.push(neighbor);
                parent.put(neighbor, node);
            }
        }
        return parent.size()==n;
    }
}
