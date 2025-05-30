package com.suri.leetcode.medium;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
https://leetcode.com/problems/minimum-size-subarray-sum
 */

public class Soln_209_Minimum_Size_Subarray_Sum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target =11;
        System.out.println(minSubArrayLen(target, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start =0;
        int sum =0;
        int minlength = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            while(sum>=target){
                int len = i-start+1;
                minlength = Math.min(minlength, len);
                sum = sum-nums[start];
                start++;
            }

        }
        return  minlength == Integer.MAX_VALUE?0:minlength;

    }
}
