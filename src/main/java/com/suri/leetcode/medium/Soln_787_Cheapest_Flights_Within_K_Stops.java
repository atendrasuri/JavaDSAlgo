package com.suri.leetcode.medium;

import java.util.*;

/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.


https://leetcode.com/problems/cheapest-flights-within-k-stops/
https://www.youtube.com/watch?v=o6dUXOk-GWQ&ab_channel=NareshGupta
 */
public class Soln_787_Cheapest_Flights_Within_K_Stops {

    public static int minCost = Integer.MAX_VALUE;
    public static void main(String[] args) {

        int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPriceDFS(flights.length, flights, 0, 2, 1));

        System.out.println(findCheapestPriceBFS(flights.length, flights, 0, 2, 1));
    }

    public static int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = buildGraph(flights);
        doDfs(graph, src, dst, k+1, 0);
        return minCost==Integer.MAX_VALUE ?-1:minCost;
    }

    private static void doDfs(Map<Integer, List<int[]>> graph, int src, int dest, int k, int currentCost){
        if(k<0){
            return;
        }
        if(src==dest){
            minCost = currentCost;
            return;
        }
        if(!graph.containsKey(src)){
            return;
        }

        for(int flight[]: graph.get(src)){
            if(currentCost+flight[1]>minCost){
                continue;
            }
            doDfs(graph, flight[0], dest, k-1, currentCost+flight[1]);
        }

    }

    public static int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = buildGraph(flights);
        int minCost = Integer.MAX_VALUE;
        Queue<int []> queue = new LinkedList<>();
        int stop =0;
        queue.add(new int[]{src,0});

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] currentStop = queue.poll();
                if(currentStop[0]==dst){
                    minCost = Math.min(minCost, currentStop[1]);
                }
                if(!graph.containsKey(currentStop[0])){
                    continue;
                }

                for(int []f : graph.get(currentStop[0])){
                    if(currentStop[1]+f[1]>minCost){
                        continue;
                    }
                    queue.add(new int[]{f[0], f[1]+currentStop[1]});
                }
            }

            if(stop++ >k){
                break;
            }
        }
        return minCost==Integer.MAX_VALUE?-1:minCost;
    }

    public static Map<Integer, List<int[]>> buildGraph(int[][] flights) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return graph;
    }


}
