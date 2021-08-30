package com.suri.companyWise.amazom.DP;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * <p>
 * You can assume that you can always reach the last index.
 */
public class MinimumJumpToReachEndofArray {
  public static void main(String[] args) {

    //int nums[] = {2, 3, 1, 1, 4};
    int nums[] = {3,2,1,0,4};
    System.out.println(jump(nums));

  }

  public static int jump(int[] nums) {

    int n = nums.length;
    if (n == 0 || nums[0] == 0) {
      // end cannot be reached
      return 0;
    }

    int i, j;

    int jumps[] = new int[n];
    jumps[0] = 0;

    // Find the minimum number of jumps to reach arr[i]
    // from arr[0], and assign this value to jumps[i]
    for (i = 1; i < n; i++) {
      jumps[i] = Integer.MAX_VALUE;
      for (j = 0; j < i; j++) {

        if (j + nums[j] >= i && jumps[j] != Integer.MAX_VALUE) {
          jumps[i] = Math.min(jumps[i], jumps[j] + 1);
          break;
        }
      }
    }
    return jumps[n - 1];

  }
}