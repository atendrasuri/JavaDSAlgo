package com.suri.leetcode.medium;

/*
Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 */
public class Soln_560_SubarraySumEqualsK {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int count =0;
        int sum=0;
        int start =0;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            if(sum==k){
                count++;
            }
            if(sum>k){
                start++;
                i = start;
                sum=nums[i];
            }

        }
        return count;

    }
}
