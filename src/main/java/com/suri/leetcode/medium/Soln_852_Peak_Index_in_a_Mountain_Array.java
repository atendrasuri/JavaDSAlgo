package com.suri.leetcode.medium;

/*
You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.



Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

https://leetcode.com/problems/peak-index-in-a-mountain-array
 */

public class Soln_852_Peak_Index_in_a_Mountain_Array {
    public static void main(String[] args) {
        int[] nums = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(nums));

    }

    public static int peakIndexInMountainArray(int[] nums) {
        int i=0;
        int n = nums.length;
        while(i<n-1 && nums[i]<nums[i+1]){
            i++;
        }
        return i;
    }
}
