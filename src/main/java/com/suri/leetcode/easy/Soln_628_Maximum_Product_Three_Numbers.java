package com.suri.leetcode.easy;

/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
https://leetcode.com/problems/maximum-product-of-three-numbers


 */


import java.util.Arrays;

public class Soln_628_Maximum_Product_Three_Numbers {

    public static void main(String[] args) {

        int nums[] = {-1,-2,-3};
        System.out.println(maximumProduct(nums));

    }

    public static int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int n= nums.length;
        int product = Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[0]*nums[1]*nums[n-1]);
        return product;
    }
}
