package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

https://leetcode.com/problems/contiguous-array

 */
public class Soln_525_Contiguous_Array {

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        int maxLen =0;
        map.put(0, -1);

        for(int i=0; i<nums.length; i++){
            count= count+( nums[i]==1?1:-1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i- map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
