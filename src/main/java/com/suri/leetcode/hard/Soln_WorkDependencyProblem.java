package com.suri.leetcode.hard;

import java.util.*;

/*
Given six documents A, B, C, D, E, F and each document has dependency on other documents as given below. Find in which order you will complete reading all documents

A - E, F
B - D, E
C - F
D - C
E - NA
F- NA


https://www.youtube.com/watch?v=6Vi5Td_a8B8&ab_channel=Pepcoding
https://leetcode.com/problems/course-schedule/
https://www.geeksforgeeks.org/find-the-ordering-of-tasks-from-given-dependencies/
 */
public class Soln_WorkDependencyProblem {
    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList("E", "F"));
        map.put("B", Arrays.asList("D", "E"));
        map.put("C", Arrays.asList("F"));
        map.put("D", Arrays.asList("C"));
        map.put("E", new ArrayList<>());
        map.put("F", new ArrayList<>());
        function1(map);

    }

    public static void function1(Map<String, List<String>> map) {

        Queue<String> order = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                doDfs(map, entry.getKey(), visited, order);
            }
        }
        while (!order.isEmpty()) {
            System.out.print(" " + order.remove());
        }
    }

    public static void doDfs(Map<String, List<String>> map, String vertice, Set<String> visited, Queue<String> order) {
        visited.add(vertice);
        for (String v : map.get(vertice)) {
            if (!visited.contains(v)) {
                doDfs(map, v, visited, order);
            }
        }
        order.add(vertice);
    }
}
