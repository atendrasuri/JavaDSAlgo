package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * <p>
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    int nums[] = {1, 5, 11, 5};

    System.out.println(canPartition(nums));

  }

  public static boolean canPartition(int[] nums) {

    if (nums.length == 0) {
      return false;
    }

    int sum = 0;

    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }

    sum /= 2;

    int n = nums.length;

    boolean dp[][] = new boolean[n + 1][sum + 1];

    dp[0][0] = true;

    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = true;
    }

    for (int j = 1; j < sum + 1; j++) {
      dp[0][j] = false;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {

        dp[i][j] = dp[i - 1][j];

        if (j >= nums[i - 1]) {
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[n][sum];

  }
}