package com.suri.leetcode.medium;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class Soln_347_Top_K_Frequent_Elements {

    public static void main(String[] args) {

        int num[] = {1,1,1,2,2,3};
        int k =2;
        int result [] = topKFrequent(num, k);
        Arrays.stream(result).forEach(a-> System.out.println(a));



    }
    public static int[] topKFrequent(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());

        queue.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty() && res.size()<k){
            res.add(queue.poll().getKey());
        }
        int result[] = new int[res.size()];

        for(int i=0;i<res.size();i++){
            result[i]= res.get(i);
        }

        return result;

    }
}
