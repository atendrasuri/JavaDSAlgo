package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
  public static void main(String[] args) {
    int nums[] = {1, 2, 3, 1};
    SolutionHouseRobberII solutionHouseRobberII = new SolutionHouseRobberII();
    System.out.println(solutionHouseRobberII.rob(nums));

  }
}

class SolutionHouseRobberII {

  public int rob(int[] nums) {

    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));

  }

  public int rob(int[] nums, int l, int h) {

    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == l) {
      return nums[l];
    }

    if (nums.length == 2) {
      return Math.max(nums[l], nums[l + 1]);
    }

    int dp[] = new int[h - l + 1];
    dp[0] = nums[l];
    dp[1] = Math.max(nums[l], nums[l + 1]);
    for (int i = l + 2; i <= h-l; i++) {
      dp[i] = Math.max(dp[i -l- 1], dp[i -l- 2] + nums[i]);
    }
    return dp[dp.length - 1];
  }
}