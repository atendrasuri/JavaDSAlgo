package com.suri.leetcode.easy;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

https://leetcode.com/problems/two-sum/
 */
public class Soln_1_TwoSum {
    public static void main(String[] args) {

        int arr[] = {2,7,11,15};
        System.out.println(twoSum(arr, 9));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int[] result = new int[2];
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[1] = j;
                    return result;
                }
            }
        }
        int[] result = new int[2];
        return result;
    }

    public static Pair<Integer, Integer> findPair(int[] nums, int target) {
        Pair<Integer, Integer> pair = null;
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                pair = Pair.of(nums[low], nums[high]);
            }
            if (nums[low] + nums[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return pair;
    }
}
