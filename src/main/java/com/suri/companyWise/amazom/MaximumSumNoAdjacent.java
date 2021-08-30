package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 * <p>
 * Examples :
 * <p>
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
 * Output : 110
 * <p>
 * Input : arr[] = {1, 2, 3}
 * Output : 4
 * <p>
 * Input : arr[] = {1, 20, 3}
 * Output : 20
 */
public class MaximumSumNoAdjacent {
  public static void main(String[] args) {
    int arr[] = {5, 5, 10, 100, 10, 5};
    System.out.println(rob(arr));

  }

  public static int rob(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int dp[] = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }
}