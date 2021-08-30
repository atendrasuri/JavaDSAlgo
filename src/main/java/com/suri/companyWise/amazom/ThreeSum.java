package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
  public static void main(String[] args) {

    int nums[]= {-1,0,1,2,-1,-4};

    System.out.println(threeSum(nums));

  }

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length < 3) {
      return result;
    }
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }


      int target = -nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      twoSumHelper(nums, result, target, left, right);

    }
    return result;
  }

  public static void twoSumHelper(int nums[], List<List<Integer>> result, int target, int left, int right) {


    while (left < right) {


      if (nums[left] + nums[right] == target) {

        List<Integer> triplet = new ArrayList<>();
        triplet.add(-target);
        triplet.add(nums[left]);
        triplet.add(nums[right]);
        result.add(triplet);
        left++;
        right--;

        while (left < right && nums[left] == nums[left - 1]) {
          left++;
        }

        while (left < right && nums[right] == nums[right + 1]) {

          right--;
        }

      } else if (nums[left] + nums[right] < target) {
        left++;
      } else if (nums[left] + nums[right] > target) {
        right--;
      }
    }
  }
}