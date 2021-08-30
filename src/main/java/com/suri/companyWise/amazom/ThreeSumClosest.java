package com.suri.companyWise.amazom;

import java.util.Arrays;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
  public static void main(String[] args) {

    int nums[] = {-1, 2, 1, -4};
    int target = 1;
    System.out.println(threeSumClosest(nums, target));

  }

  public static int threeSumClosest(int[] nums, int target) {

    if (nums == null || nums.length < 3) {
      return -1;
    }

    int result = nums[0] + nums[1] + nums[2];


    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }

        if (sum < target) {
          left++;
        } else {
          right--;
        }
      }

    }
    return result;
  }
}