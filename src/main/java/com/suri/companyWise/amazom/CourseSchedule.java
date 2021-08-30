package com.suri.companyWise.amazom;

import java.util.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
  public static void main(String[] args) {

    int pre[][] = {{1, 0}, {0, 1}};
    System.out.println(canFinish(2, pre));

  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    int indegree[] = new int[numCourses];

    Map<Integer, List<Integer>> adj = new HashMap<>();

    for (int pr[] : prerequisites) {

      List<Integer> l = adj.getOrDefault(pr[1], new ArrayList<>());
      l.add(pr[0]);
      indegree[pr[0]]++;
      adj.put(pr[1], l);
    }

    Queue<Integer> queue = new LinkedList<>();
    int count = 0;
    for (int i = 0; i < indegree.length; i++) {

      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int src = queue.remove();

      if (indegree[src] == 0) {
        count++;
      }
      if (!adj.containsKey(src)) {
        continue;
      }

      for (int next : adj.get(src)) {
        indegree[next]--;

        if (indegree[next] == 0) {
          queue.add(next);
        }
      }
    }
    return count == numCourses;

  }
}