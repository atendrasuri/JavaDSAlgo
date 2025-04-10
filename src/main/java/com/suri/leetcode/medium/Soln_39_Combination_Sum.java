package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
https://leetcode.com/problems/combination-sum/description

 */
public class Soln_39_Combination_Sum {
    public static void main(String[] args) {

        int candidates[] = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if(candidates.length==0 || target==0){
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();

        doSum(candidates, target, result, combination, 0);
        return result;
    }

    public static void doSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, int index){

        if(target ==0){

            result.add(new ArrayList<>(combination)) ;
        }

        for(int i = index; i<candidates.length; i++){

            if(candidates[i]>target){
                break;
            }

            combination.add(candidates[i]);

            doSum(candidates, target-candidates[i], result, combination, i);
            combination.remove(combination.size()-1);
        }


    }
}
