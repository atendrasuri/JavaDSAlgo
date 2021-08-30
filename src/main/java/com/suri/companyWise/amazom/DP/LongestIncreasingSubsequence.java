package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};

    System.out.println(lengthOfLIS(nums));

  }

  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int dp[] = new int[nums.length];

    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j <= i; j++) {

        if (nums[j] < nums[i]) {

          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int max = 0;

    for (int i = 0; i < dp.length; i++) {
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return max;

  }
}