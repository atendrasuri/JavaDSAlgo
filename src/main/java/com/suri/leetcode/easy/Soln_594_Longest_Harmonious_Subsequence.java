package com.suri.leetcode.easy;

/*
https://leetcode.com/problems/longest-harmonious-subsequence
We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious
subsequence
 among all its possible subsequences.



Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]

Output: 2

Explanation:

The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:

Input: nums = [1,1,1,1]

Output: 0

Explanation:

No harmonic subsequence exists.
 */


import java.util.HashMap;
import java.util.Map;

public class Soln_594_Longest_Harmonious_Subsequence {

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {

        int result =0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            if(map.containsKey(key+1)){
                int length = map.get(key)+map.get(key+1);
                result = Math.max(length, result);
            }
        }
        return result;

    }
}
