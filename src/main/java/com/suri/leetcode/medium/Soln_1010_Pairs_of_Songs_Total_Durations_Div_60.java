package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

 */

public class Soln_1010_Pairs_of_Songs_Total_Durations_Div_60 {
    public static void main(String[] args) {

        int time1[] = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(time1));
        int time2[] = {60,60,60};
        System.out.println(numPairsDivisibleBy60(time2));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap();
        int count =0;
        for(int i=0;i<time.length;i++){
            int reminder = time[i]%60;
            if(reminder==0){
                count+= map.getOrDefault(reminder, 0);
            }else{
                count+= map.getOrDefault(60-reminder, 0);
            }
            map.put(reminder, map.getOrDefault(reminder,0)+1);
        }
        return count;
    }
}
