package com.suri.leetcode.medium;
/*
https://leetcode.com/problems/permutations/description/

Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */

import java.util.ArrayList;
import java.util.List;

public class Soln_46_Permutations {

    public static void main(String[] args) {

        int nums[] = {1,2,3};
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        compute(nums, results, result);

        for(List<Integer> result1:results){
            System.out.println(result1);
        }


    }


    public static void compute(int nums[], List<List<Integer>> results, List<Integer> result){

        if(result.size()==nums.length){
            results.add(new ArrayList<>(result));
            return;
        }

        for(int i=0;i<nums.length; i++){
            if(!result.contains(nums[i])){
                result.add(nums[i]);
                compute(nums, results, result);
                result.remove(result.size()-1);
            }

        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean visit[] = new boolean[nums.length];
        compute(nums, results, result, visit);
        return results;
    }


    public static void compute(int nums[], List<List<Integer>> results, List<Integer> result, boolean[] visit){

        if(result.size()==nums.length){
            results.add(new ArrayList<>(result));
            return;
        }

        for(int i=0;i<nums.length; i++){
            if(visit[i]!=true){
                visit[i]= true;
                result.add(nums[i]);
                compute(nums, results, result , visit);
                result.remove(result.size()-1);
                visit[i]= false;
            }
        }
    }
}
