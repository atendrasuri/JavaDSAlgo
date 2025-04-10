package com.suri.leetcode.medium;
/*
You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.



Example 1:


Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
Example 2:

Example 1 Diagram
Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.
Example 3:


Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
https://leetcode.com/problems/two-best-non-overlapping-events
 */

import com.suri.common.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Soln_2054_Two_Best_Non_Overlapping_Events {
    public static void main(String[] args) {

        int[][] events = {{1,3,2},{4,5,2},{1,5,5}};
        System.out.println(maxTwoEvents(events));

    }
    public static int maxTwoEvents(int[][] events) {
        //Create a PriorityQueue to store the pair ending time and value.
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b)-> a.key -b.value);
        //Sort the array in ascending order
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int maxVal= 0;
        int maxSum =0;

        for(int []event : events){

            // Poll all valid events from queue and take their maximum.
            while(!minHeap.isEmpty() && minHeap.peek().key <event[0]){
                maxVal = Math.max(maxVal, minHeap.peek().value);
                minHeap.remove();
            }

            maxSum = Math.max(maxSum, maxVal+event[2]);

            minHeap.add(new Pair<>(event[1], event[2]));

        }
        return maxSum;


    }
}
