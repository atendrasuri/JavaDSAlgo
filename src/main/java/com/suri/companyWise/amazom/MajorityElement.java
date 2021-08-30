package com.suri.companyWise.amazom;

import java.util.Arrays;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 30/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Soln:- Boyer–Moore majority vote algorithm
 */
public class MajorityElement {
  public static void main(String[] args) {
    int arr[] = {3, 1, 2, 5, 6, 2, 2, 2, 2};

    System.out.println(majorityElement(arr));

    System.out.println(majorityElementII(arr));


  }

  public static int majorityElement(int[] nums) {

    Integer candidate = null;

    int count = 0;

    for (int i = 0; i < nums.length; i++) {

      if (count == 0) {
        candidate = nums[i];
        count = 1;
      } else if (candidate == nums[i]) {
        count++;
      } else {
        count--;
      }
    }

    if (count == 0) {
      return -1;
    }

    count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (candidate == nums[i]) {
        count++;
      }
    }

    return count > nums.length / 2 ? candidate : -1;

  }

  /**
   * second approach
   */

  public static int majorityElementII(int nums[]){

    Arrays.sort(nums);

    return nums[nums.length/2];
  }
}