package com.suri.leetcode.medium;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.



Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
https://leetcode.com/problems/non-overlapping-intervals/description/
 */

import java.util.Arrays;

public class Soln_interval_435_Non_overlapping_Intervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));

    }
    public static int eraseOverlapIntervals(int[][] intervals) {


        Arrays.sort(intervals, (a, b)->a[0]-b[0]);

        int prevEnd = intervals[0][1];
        int count =0;


        for(int i =1; i<intervals.length;i++){

            if(intervals[i][0]< prevEnd){
                // Overlap detected; remove one interval
                count++;

                // Keep the interval with the smaller end time
                prevEnd = Math.min(prevEnd, intervals[i][1]);

            }else{
                // No overlap; update the last non-overlapping end time
                prevEnd = intervals[i][1];
            }
        }
        return count;

    }
}
