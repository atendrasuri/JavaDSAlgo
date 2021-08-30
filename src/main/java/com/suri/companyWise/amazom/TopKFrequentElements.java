package com.suri.companyWise.amazom;

import java.util.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
  public static void main(String[] args) {

    int nums[] = {1,1,1,2,2,3};

    System.out.println(topKFrequent(nums,2));
  }

  public static List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
    );

    priorityQueue.addAll(map.entrySet());

    while (!priorityQueue.isEmpty() && result.size() < k) {
      result.add(priorityQueue.poll().getKey());
    }
    return result;

  }
}