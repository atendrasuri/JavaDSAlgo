package com.suri.leetcode.medium;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

 https://leetcode.com/problems/meeting-rooms-ii/description
 https://neetcode.io/problems/meeting-schedule-ii
 https://www.youtube.com/watch?v=bgZmJiPfkYE&t=827s&ab_channel=CodingWithPrakash


 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class Soln_Interval_253_Meeting_Rooms_II {

    public static void main(String[] args) {

        int [][] intervals = {{0,30},{5,10},{15,20}};

        System.out.println(minMeetingRooms(intervals));

    }

    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int [] interval : intervals){
            if(priorityQueue.isEmpty()){
                priorityQueue.add(interval[1]);
                continue;
            }
            if(priorityQueue.peek()<= interval[0]){
                priorityQueue.remove();
            }
            priorityQueue.add(interval[1]);

        }
        return priorityQueue.size();

    }
}
