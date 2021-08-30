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
 * @History: Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
  public static void main(String[] args) {

    int nums[] = {1, 0, -1, 0, -2, 2};

    int target = 0;
    System.out.println(fourSum(nums, 0));

  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {


    List<List<Integer>> result = new ArrayList<>();


    if (nums == null || nums.length < 4) {
      return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {


      if (i > 0 && nums[i] == nums[i - 1]) {

        continue;
      }


      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j != i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }

        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];


          if (sum < target) {


            left++;
          } else if (sum > target) {
            right--;
          } else {

            ArrayList<Integer> quadruplet = new ArrayList<>();

            quadruplet.add(nums[i]);
            quadruplet.add(nums[j]);
            quadruplet.add(nums[left]);
            quadruplet.add(nums[right]);
            result.add(quadruplet);
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }

          }


        }
      }
    }
    return result;
  }
}