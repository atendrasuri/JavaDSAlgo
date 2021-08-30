package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class FindKPairsWithSmallestSums {
  public static void main(String[] args) {

    int nums1[] = {1, 7, 11};
    int nums2[] = {2, 4, 6};

    System.out.println(kSmallestPairs(nums1, nums2, 3));

  }

  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - (b[0] + b[1]));

    List<List<Integer>> result = new ArrayList<>();


    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        minHeap.add(new Integer[]{new Integer(nums1[i]), new Integer(nums2[j])});

      }
    }

    while (!minHeap.isEmpty() && result.size() < k) {
      Integer[] res = minHeap.remove();
      List<Integer> ls = new ArrayList<>();
      ls.add(res[0]);
      ls.add(res[1]);
      result.add(ls);
    }

    return result;

  }
}