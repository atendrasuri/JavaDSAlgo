package com.suri.companyWise.amazom;

/**
 * Sum of minimum elements of all subarrays
 * Given an array A of n integers. The task is to find the sum of minimum of all possible (contiguous) subarray of A.
 *
 * Examples:
 *
 * Input: A = [3, 1, 2, 4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3, 1], [1, 2], [2, 4], [3, 1, 2], [1, 2, 4], [3, 1, 2, 4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum is 17.
 */
public class SumOfMinElementsAllSubArray {
  public static void main(String[] args) {
    int arr[] = {3, 1, 2, 4};
    System.out.println(findSumOfMinElementsAllSubArray(arr));

  }

  public static int findSumOfMinElementsAllSubArray(int arr[]) {

    int minSum = 0;
    for (int i = 0; i < arr.length; i++) {

      for (int j = 0; j < arr.length; j++) {
        if (i + j < arr.length) {
          minSum += findMin(arr, j, j + i);
        }
      }
    }
    return minSum;
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