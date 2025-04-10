package com.suri.leetcode.medium;

/*
Given an integer array nums, return the length of the longest strictly increasing
subsequence
.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

https://leetcode.com/problems/longest-increasing-subsequence/description

[COMPANY TAGS] = Google, TikTok, Microsoft, Walmart Labs, Amazon, Splunk, Bloomberg, Oracle
Apple, Goldman Sachs, Adobe, Uber, Meta, Atlassian, Commvault, Accenture, IBM, Zoho
 */

public class Soln_DP_300_Longest_Increasing_Subsequence {

    public static void main(String[] args) {

       int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }
    public static int lengthOfLIS(int[] nums) {


        if(nums.length==0){
            return 0;
        }

        int dp[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i] =1;
        }

        for(int i=1;i<dp.length;i++){

            for(int j =0;j<=i;j++){
                if(nums[j]<nums[i]){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max =0;

        for(int i=0;i<nums.length;i++){
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
