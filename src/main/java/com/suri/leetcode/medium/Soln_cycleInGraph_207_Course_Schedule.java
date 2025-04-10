package com.suri.leetcode.medium;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

https://leetcode.com/problems/course-schedule/
 */


public class Soln_cycleInGraph_207_Course_Schedule {
    public static void main(String[] args) {
        //int arr[][] = {{1,0},{0,1}};

        /*int arr[][] = {{1,0}};
        System.out.println(canFinish(2,arr));*/
        int numCourses = 6;
        int [][]prerequisites = {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {5, 4}};
        System.out.println(canFinishKhanAlgorithms(numCourses, prerequisites));

    }

    public static boolean canFinishKhanAlgorithms(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[]prerequisite : prerequisites ){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int nodeVisited=0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            nodeVisited++;
            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.add(neighbor);
                }

            }
        }
        return nodeVisited==numCourses;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int arr[]:prerequisites){
            int src = arr[0];
            int dep = arr[1];
            if(!map.containsKey(src)){
                map.put(src, new ArrayList<>());
            }
                map.get(src).add(dep);

        }
        return canFinish(numCourses,map);

    }

    private static boolean canFinish(int n, Map<Integer, List<Integer>> map) {
        int visited[] = new int[n];

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            if (isCycle(map, e.getKey(), visited)) {
                return false;
            }
        }
        return true;
    }

    /*
     * 0 - Unvisited.
     * 1 - Processing.
     * 2 - Processed.
     */
    private static boolean isCycle(Map<Integer, List<Integer>> map, Integer src, int[] visited) {
        // We're Returing true as a Cycle is Found.
        // Like,While processing a node, You have found which is also in its processing in its way.
        if (visited[src] == 1) {
            return true;
        }
        // If No We have made that node as visited
        visited[src] = 1;
        if(map.containsKey(src)) {
            //Iterating over its adjacent nodes that we stored.
            for (int v : map.get(src)) {
                //If a Node is not processed That is, If it haven't completed its process, we're calling the function again in a if condition by checking whether it forms a cycle or not.

                if (visited[v] != 2) {
                    if (isCycle(map, v, visited)) {
                        return true;
                    }
                }
            }
        }
        //If No Cycle then the node is totally proccessed and we changed the visited state as 2.
        visited[src] = 2;

        //As No Cycle Detected We return false.
        return false;
    }
}
