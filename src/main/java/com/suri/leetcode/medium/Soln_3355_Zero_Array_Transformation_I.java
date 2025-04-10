package com.suri.leetcode.medium;
/*
You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

Select a
subset
 of indices within the range [li, ri] in nums.
Decrement the values at the selected indices by 1.
A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.



Example 1:

Input: nums = [1,0,1], queries = [[0,2]]

Output: true

Explanation:

For i = 0:
Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
The array will become [0, 0, 0], which is a Zero Array.
Example 2:

Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]

Output: false

Explanation:

For i = 0:
Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
The array will become [4, 2, 1, 0].
For i = 1:
Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
The array will become [3, 1, 0, 0], which is not a Zero Array.
https://leetcode.com/problems/zero-array-transformation-i
 */
public class Soln_3355_Zero_Array_Transformation_I {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int [][] queries = {{0,2}};

        System.out.println(isZeroArray(nums, queries));

    }
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n];
        for(int [] q: queries){
            freq[q[0]]++;

            if(q[1]+1<n){
                freq[q[1]+1]--;
            }
        }
        int curFreq=0;
        for(int i=0;i<n;i++){

            curFreq+= freq[i];
            if(curFreq<nums[i]){
                return false;
            }
        }
        return true;

    }
}
