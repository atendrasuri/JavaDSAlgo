package com.suri.leetcode.medium;

/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
https://leetcode.com/problems/maximum-sum-circular-subarray


 */

public class Soln_918_Maximum_Sum_Circular_Subarray {

    public static void main(String[] args) {
        int[] nums= {5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));

    }

    public static int maxSubarraySumCircular(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int maxSum = nums[0];
        int maxSofar = nums[0];
        int n = nums.length;

        for(int i=1;i<n;i++){

            maxSum = Math.max(maxSum+nums[i], nums[i]);
            maxSofar = Math.max(maxSum, maxSofar);
        }


        int minSofar = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];


        for(int i=1;i<n;i++){
            minSum = Math.min(nums[i]+minSum, nums[i]);
            minSofar = Math.min(minSofar, minSum);
            totalSum+= nums[i];
        }

        // If all numbers are negative, the circular subarray case is invalid.
        if(totalSum==minSofar){
            return maxSofar;
        }

        return Math.max(maxSofar, totalSum-minSofar);

    }
}
