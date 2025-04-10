package com.suri.leetcode.medium;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

https://leetcode.com/problems/longest-consecutive-sequence
 */

import java.util.Arrays;

public class Soln_128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        int currentLength =1;
        int maxLength =1;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){

            if(nums[i]!= nums[i-1]){

                if(nums[i]== nums[i-1]+1){
                    currentLength++;
                }else{
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength=1;
                }
            }
        }
        return Math.max(maxLength, currentLength);

    }
}
