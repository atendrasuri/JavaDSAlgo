package com.suri.leetcode.medium;
/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15

https://leetcode.com/problems/binary-subarrays-with-sum
 */

import java.util.HashMap;
import java.util.Map;

public class Soln_930_Binary_Subarrays_With_Sum {
    public static void main(String[] args) {

        int[] nums = {1,0,1,0,1};
        int goal =2;
        System.out.println(numSubarraysWithSum(nums, goal));

        System.out.println(slidingWindowAtMost(nums, goal)- slidingWindowAtMost(nums, goal-1));

    }

    // Approach 1: Prefix Sum
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int currentsum = 0;
        int totalCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            currentsum += num;
            if (currentsum == goal) {
                totalCount++;
            }
            if (map.containsKey(currentsum - goal)) {
                totalCount += map.get(currentsum - goal);
            }
            map.put(currentsum, map.getOrDefault(currentsum, 0) + 1);
        }
        return totalCount;
    }

    //Approach 2: Sliding Window

    public static int slidingWindowAtMost(int[] nums, int goal){
        int start = 0, currentSum = 0, totalCount = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            // Adjust the window by moving the start pointer to the right
            // until the sum becomes less than or equal to the goal
            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }
            totalCount += end - start + 1;
        }
        return totalCount;
    }
}
