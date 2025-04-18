package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
https://leetcode.com/problems/subarray-sum-equals-k/description/
https://www.youtube.com/watch?v=fFVZt-6sgyo&t=329s

 */
public class Soln_560_Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int sum=0;
            int count=0;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for(int i=0;i<n;i++){
                sum+= nums[i];
                if(map.containsKey(sum-k)){
                    count+= map.get(sum-k);
                }
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
            return count;
        }

    }

