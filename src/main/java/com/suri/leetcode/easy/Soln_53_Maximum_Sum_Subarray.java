package com.suri.leetcode.easy;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

https://leetcode.com/problems/maximum-subarray/

Asked in LogMeIn
 */
public class Soln_53_Maximum_Sum_Subarray {
    public static void main(String[] args) {

        int nums1[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums1));
        int nums2[] = {1,-5,10,-2,3,-10,1};
        System.out.println(maxSubArray(nums2));
        int nums3[] = {-1,-2,-3};
        System.out.println(maxSubArray(nums3));

        System.out.println(maxSubArray1(nums3));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }


    public static int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int currmax = nums[0];
        int maxSumSofar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currmax = Math.max(currmax + nums[i], nums[i]);
            maxSumSofar = Math.max(currmax, maxSumSofar);
        }
        return maxSumSofar;

    }
}
