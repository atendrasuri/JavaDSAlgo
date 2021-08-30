package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
  public static void main(String[] args) {

    int result[] = maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5},
            3);

    for (int a : result) {
      System.out.print(a + " ");
    }

  }

  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }

    LinkedList<Integer> list = new LinkedList<>();

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {

      while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
        list.removeLast();
      }
      list.add(i);
    }

    for (int i = k; i < nums.length; i++) {

      result.add(nums[list.getFirst()]);

      while (!list.isEmpty() && list.getFirst() < (i - k + 1)) {
        list.removeFirst();
      }

      while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
        list.removeLast();
      }
      list.add(i);

    }
    result.add(nums[list.peek()]);
    int result1[] = new int[result.size()];
    int i = 0;
    for (int a : result) {
      result1[i++] = a;
    }
    return result1;
  }
}