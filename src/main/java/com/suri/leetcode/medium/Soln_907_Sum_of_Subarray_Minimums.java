package com.suri.leetcode.medium;

/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 *
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 */
public class Soln_907_Sum_of_Subarray_Minimums {
  public static void main(String[] args) {
    int arr[] = {3,1,2,4};
    System.out.println(sumSubarrayMins(arr));

  }
  public static int sumSubarrayMins(int[] arr) {
    int minSum = 0;
    for (int i = 0; i < arr.length; i++) {

      for (int j = 0; j < arr.length; j++) {
        if (i + j < arr.length) {
          minSum += findMin(arr, j, j + i);
        }
      }
    }
    int mod =(int) 1e9 +7;
    return minSum % mod;

  }
  public static int findMin(int arr[], int l, int r) {


    int min = Integer.MAX_VALUE;

    for (int i = l; i <= r; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }
}