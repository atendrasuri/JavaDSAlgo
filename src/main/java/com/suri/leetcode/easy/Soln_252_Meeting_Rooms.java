package com.suri.leetcode.easy;

import java.util.Arrays;

/*

https://leetcode.com/problems/meeting-rooms/description/
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true

 */
public class Soln_252_Meeting_Rooms {

    public static void main(String[] args) {

        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(intervals));

    }

    public static boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));


        for(int i=1;i<intervals.length;i++){

            int[] i1 = intervals[i-1];
            int[] i2 = intervals[i];

            if(i1[1]>i2[0]){
                return false;
            }
        }
        return true;

    }
}
