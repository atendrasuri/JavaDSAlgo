package com.suri.leetcode.medium;
/*

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

https://leetcode.com/problems/daily-temperatures/description/
 */

import java.util.Arrays;
import java.util.Stack;

public class Soln_739_Daily_Temperatures {
    public static void main(String[] args) {

        int []temperatures = {30,38,30,36,35,40,28};
        int result[] = dailyTemperatures(temperatures);
    }

    public static int[] dailyTemperatures(int[] temperatures) {


        int n = temperatures.length;

        int result[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, 0);

        for(int i=0;i<n; i++){

            int next = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()]<next){
                int prevIndex = stack.pop();
                result[prevIndex]= i - prevIndex;
            }
            stack.push(i);
        }
        return result;

    }
}
