package com.suri.leetcode.medium;

/**
  Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 */
public class Soln_238_ProductofArrayExceptSelf {
  public static void main(String[] args) {
    int arr[] ={1,2,3,4};

    int result[] = productExceptSelf(arr);
    for(int a:result){
      System.out.println(a);
    }

  }

  public static int[] productExceptSelf(int[] nums) {

    int result[] = new int[nums.length];

    int left[] = new int[nums.length];
    int right[] = new int[nums.length];

    int n = nums.length;

    left[0] = 1;
    right[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }

    for (int i = n - 2; i >= 0; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < n; i++) {
      result[i] = left[i] * right[i];
    }

    return result;

  }
}