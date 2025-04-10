package com.suri.leetcode.easy;

/**
 Given an array of positive integers nums, return the maximum possible sum of an
 strictly increasing subarray
 in nums.

 A subarray is defined as a contiguous sequence of numbers in an array.



 Example 1:

 Input: nums = [10,20,30,5,10,50]
 Output: 65
 Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
 Example 2:

 Input: nums = [10,20,30,40,50]
 Output: 150
 Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
 Example 3:

 Input: nums = [12,17,15,13,10,11,12]
 Output: 33
 Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.

 https://leetcode.com/problems/maximum-ascending-subarray-sum

 */

public class Soln_1800_Maximum_Ascending_Subarray_Sum {
    public static void main(String[] args) {
        int [] nums = {12,17,15,13,10,11,12};
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int maxSum =0;
        for(int i=0;i<nums.length; i++){
            int currentSum = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]>nums[j-1]){
                    currentSum+= nums[j];
                }else{
                    break;
                }
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;

    }
}
