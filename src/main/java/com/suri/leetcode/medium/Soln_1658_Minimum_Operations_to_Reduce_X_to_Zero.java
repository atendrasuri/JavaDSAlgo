package com.suri.leetcode.medium;

/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.



Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero

Algorithm (Sliding Window)
Compute
total_sum
=
sum(nums)
total_sum=sum(nums). If
total_sum
<
𝑥
total_sum<x, return -1.
Set
target
=
total_sum
−
𝑥
target=total_sum−x.
Use a sliding window with two pointers (start and end) to maintain the sum of the current subarray.
Expand the end pointer and add nums[end] to the current sum.
If the current sum exceeds the target, move the start pointer forward to reduce the sum.
Track the maximum subarray length when the current sum equals the target.
If no subarray is found, return -1. Otherwise, return
nums.length
−
max_length
nums.length−max_length.
 */
public class Soln_1658_Minimum_Operations_to_Reduce_X_to_Zero {
    public static void main(String[] args) {
        int[] nums = {3,2,20,1,1,3};
        System.out.println(minOperations(nums, 10));

    }
    public static int minOperations(int[] nums, int x) {

        int totalsum =0;

        for(int num:nums){
            totalsum+=num;
        }

        int targetsum = totalsum-x;


        int start =0;
        int currentsum =0;
        int maxLength =-1;


        for(int end =0; end<nums.length;end++){

            currentsum+= nums[end];

            while(currentsum>targetsum && start<=end){
                currentsum = currentsum-nums[start];
                start++;

            }
            if(currentsum==targetsum){
                maxLength = Math.max(maxLength, end-start+1);

            }

        }
        return maxLength==-1?-1:nums.length-maxLength;

    }
}
