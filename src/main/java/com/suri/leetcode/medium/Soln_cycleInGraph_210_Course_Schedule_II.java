package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

https://leetcode.com/problems/course-schedule-ii
 */

public class Soln_cycleInGraph_210_Course_Schedule_II {

    public static void main(String[] args) {

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int [] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] prerequisite: prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int nodeVisited =0;

        while(!queue.isEmpty()){
            int node = queue.remove();
            result[nodeVisited++] = node;
            for(int neighbor : adj.get(node)){

                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }

        return  numCourses ==  nodeVisited ? result: new int[]{};
    }

}

/*

Approach 1: Topological Sort Using Kahn's Algorithm
Intuition
We can see that we have been given certain courses with some dependencies between them. The dependencies are expressed as pairs, which provides some hints for framing the problem in terms of a graph.

If we regard each course as a node and draw an edge from b

If there is a cycle in this directed graph, it suggests that we will not be able to finish all of the courses. Otherwise, we can perform a topological sort of the graph to determine the order in which all of the courses can be finished.

As a result, the problem is reduced to determining whether a cycle occurs in a graph. If there is a cycle, we must return false. If not, we return true.

A topological sort or topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge u -> v from vertex u to vertex v, u comes before v in the ordering.

In a directed acyclic graph, we can use Kahn's algorithm to get the topological ordering. Kahn’s algorithm works by keeping track of the number of incoming edges into each node (indegree). It works by repeatedly visiting the nodes with an indegree of zero and deleting all the edges associated with it leading to a decrement of indegree for the nodes whose incoming edges are deleted. This process continues until no elements with zero indegree can be found.

If you are not familiar with Kahn's algorithm, we suggest you read our LeetCode Explore Card.

The advantage of using Kahn's algorithm is that it also aids in the detection of graph cycles.

Let's perform Kahn's algorithm on a directed graph having a cycle. Here's a visual step-by-step representation of how it would work:

img

We can see that if there is a cycle, the indegree of nodes in the cycle cannot be set to 0 due to cyclic dependency. We are unable to visit the cycle's nodes. So, if the number of visited nodes is less than the total number of nodes in the graph, we have a cycle.

Algorithm
Create an array indegree of length n where indegree[x] stores the number of edges entering node x.
We create an adjacency list adj in which adj[x] contains all the nodes with an incoming edge from node x, i.e., neighbors of node x. We create this adjacency list by iterating over prerequisites. For every prerequisite in prerequisites, we add an edge from prerequisite[1] to prerequisite[0] and increment the indegree of prerequisite[0] by 1.
Initialize a queue of integers q and start a BFS algorithm moving from the leaf nodes to the parent nodes.
Begin the BFS traversal by pushing all of the leaf nodes (indegree equal to 0) in the queue.
Create an integer variable nodesVisited = 0 to count the number of visited nodes.
While the queue is not empty;
Dequeue the first node from the queue.
Increment nodesVisited by 1.
For each neighbor (nodes that have an incoming edge from node) of node, we decrement indegree[neighbor]by 1 to delete the node -> neighbor edge.
If indegree[neighbor] == 0, it means that neighbor behaves as a leaf node, so we push neighbor in the queue.
If the number of nodes visited is less than the total number of nodes, i.e., nodesVisited < n we return false as there must be a cycle. Otherwise, if nodesVisited == numCourses, we return true. We can shorten it to just return nodesVisited == numCourses

 */

/*

Complexity Analysis
Here, n be the number of courses and m be the size of prerequisites.

Time complexity: O(m+n)

Initializing the adj list takes O(m) time as we go through all the edges. The indegree array take O(n) time.
Each queue operation takes O(1) time, and a single node will be pushed once, leading to O(n) operations for n nodes. We iterate over the neighbors of each node that is popped out of the queue iterating over all the edges once. Since there are total of m edges, it would take O(m) time to iterate over the edges.
Space complexity: O(m+n)

The adj arrays takes O(m) space. The indegree array takes O(n) space.
The queue can have no more than n elements in the worst-case scenario. It would take up O(n) space in that case.
 */
