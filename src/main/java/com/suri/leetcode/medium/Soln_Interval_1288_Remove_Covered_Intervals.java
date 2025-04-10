package com.suri.leetcode.medium;
/*
Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.



Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1


Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li < ri <= 105
All the given intervals are unique.
https://leetcode.com/problems/remove-covered-intervals/description/

 */

import java.util.Arrays;

public class Soln_Interval_1288_Remove_Covered_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{3,6},{2,8}};

        System.out.println(removeCoveredIntervals(intervals));

    }

    public static int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

        int left =-1;
        int right =-1;
        int result =0;

        for(int [] interval:intervals){

            if(interval[0]>left && interval[1]> right){
                left = interval[0];
                result = result+1;
            }
            right = Math.max(right, interval[1]);
        }
        return result;

    }
}
