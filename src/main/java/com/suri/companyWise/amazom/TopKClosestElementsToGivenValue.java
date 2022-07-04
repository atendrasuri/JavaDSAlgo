package com.suri.companyWise.amazom;

import java.util.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */
public class TopKClosestElementsToGivenValue {
  public static void main(String[] args) {

    int nums[] = {1, 2, 3, 4, 5};
    int k = 4;
    int x = 3;
    System.out.println(findClosestElements(nums, k, x));
    System.out.println(findClosestElements1(nums, k, x));

  }

  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();


    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {

      map.put(num, Math.abs(x - num));
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue();

    maxHeap.addAll(map.keySet());
    int x1 = maxHeap.remove();

    for (int key : map.keySet()) {

      if (maxHeap.size() < k) {
        maxHeap.add(key);
      } else {
        int temp = maxHeap.peek();
        if (map.get(temp) > map.get(key)) {
          maxHeap.remove();
          maxHeap.add(key);
        }
      }
    }

    while (!maxHeap.isEmpty()) {
      result.add(maxHeap.remove());
    }
    return result;

  }

  // 2nd approach

  public static List<Integer> findClosestElements1(int[] nums, int k, int x) {

    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, Math.abs(x - num));
    }


    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
    );

    priorityQueue.addAll(map.entrySet());

    while (!priorityQueue.isEmpty() && result.size() < k) {
      result.add(priorityQueue.poll().getKey());
    }
    Collections.sort(result);
    return result;

  }
}