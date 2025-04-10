package com.suri.leetcode.medium;

/*
Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
https://leetcode.com/problems/subsets-ii/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soln_90_Subsets_II {

    public static void main(String[] args) {
        int [] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        compute(nums, results, new ArrayList<>(), 0);
        return results;

    }

    public static void compute(int[] nums, List<List<Integer>>  results, List<Integer> result, int start){
        results.add(new ArrayList<>(result));
        for(int i=start; i<nums.length; i++){

            if(i>start && nums[i]== nums[i-1]){
                continue;
            }
            result.add(nums[i]);
            compute(nums, results, result, i+1);
            result.remove(result.size()-1);
        }
    }
}
