package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
https://leetcode.com/problems/combination-sum-ii/description/
 */
public class Soln_40_Combination_Sum_II {
    public static void main(String[] args) {

        int nums[] = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(nums, 8));

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        compute(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }


    public static void compute(int nums[], int target, List<List<Integer>> results, List<Integer> result, int start){

        if(target==0){
            results.add(new ArrayList<>(result));
            return;
        }
        if(target<0){
            return;
        }

        for(int i=start; i<nums.length;i++){

            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            result.add(nums[i]);
            compute(nums, target-nums[i], results, result, i+1);
            result.remove(result.size()-1);
        }
    }
}
