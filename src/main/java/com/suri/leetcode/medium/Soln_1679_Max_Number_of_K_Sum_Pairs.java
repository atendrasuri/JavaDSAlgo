package com.suri.leetcode.medium;

import java.util.Arrays;

/*

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.



Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
https://leetcode.com/problems/max-number-of-k-sum-pairs
 */
public class Soln_1679_Max_Number_of_K_Sum_Pairs {
    public static void main(String[] args) {
        int[] nums= {3,1,3,4,3};
        System.out.println(maxOperations(nums, 6));

    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        int right = nums.length-1;
        int count =0;
        while(left<right){
            if(nums[left]+nums[right]<k){
                left++;
            }else if(nums[left]+nums[right]>k){
                right--;
            }else{
                left++;
                right--;
                count++;
            }
        }

        return count;

    }
}
