package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.



Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

https://leetcode.com/problems/find-the-difference-of-two-arrays
 */
public class Soln_2215_Find_the_Difference_of_Two_Arrays {

    public static void main(String[] args) {

        int[] nums1= {1,2,3,3};
        int [] nums2 = {1,1,2,2};

        System.out.println(findDifference(nums1, nums2));

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int num: nums1){
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }

        for(int num: nums2){
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }

        List<Integer> result1 = new ArrayList<>();
        for(int key: map1.keySet()){
            if(!map2.containsKey(key)){
                result1.add(key);
            }
        }

        List<Integer> result2 = new ArrayList<>();
        for(int key: map2.keySet()){
            if(!map1.containsKey(key)){
                result2.add(key);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        return result;
    }
}
