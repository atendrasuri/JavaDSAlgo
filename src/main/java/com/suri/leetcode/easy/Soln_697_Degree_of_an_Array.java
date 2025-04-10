package com.suri.leetcode.easy;

/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
https://leetcode.com/problems/degree-of-an-array/description/
 */

import java.util.HashMap;
import java.util.Map;

public class Soln_697_Degree_of_an_Array {
    public static void main(String[] args) {

        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));

    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
            firstIndex.putIfAbsent(num, i);
            lastIndex.put(num, i);
        }

        // find the degree of the Array
        int degree=0;
        for(int freq: frequency.values()){
            degree = Math.max(degree, freq);
        }

        // Find the shortest subarray with the same degree
        int minLength = nums.length;
        for(int num : frequency.keySet()){
            if(frequency.get(num)==degree){

                int firstIdx  = firstIndex.get(num);
                int lastIdx = lastIndex.get(num);
                int length =  lastIdx-firstIdx+1;
                minLength = Math.min(minLength, length);
            }
        }
        return minLength;
    }
}
