package com.suri.companyWise.amazom;

import java.util.PriorityQueue;

/**
 * @History: Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
  public static void main(String[] args) {
    int nums[] = {1, 4, 2, 0};
    System.out.println(firstMissingPositive(nums));

  }

  public static int firstMissingPositive(int[] arr) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= 0) {
        minHeap.add(arr[i]);
      }
    }

    int c = 0;
    while (!minHeap.isEmpty()) {
      if (minHeap.peek() == c || minHeap.peek() - 1 == c) {
        c = minHeap.remove();
      } else {
        return c + 1;
      }
    }
    return c + 1;
  }
}