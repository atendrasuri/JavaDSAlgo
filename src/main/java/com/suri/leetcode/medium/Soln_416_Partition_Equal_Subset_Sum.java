package com.suri.leetcode.medium;

/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class Soln_416_Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));

    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num:nums){
            sum+= num;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean dp[] = new boolean[target+1];
        dp[0]= true;
        for(int num:nums){
            for(int j = target; j>=num;j--){
                dp[j]= dp[j]|| dp[j-num];
            }
        }
        return dp[target];

    }
}
