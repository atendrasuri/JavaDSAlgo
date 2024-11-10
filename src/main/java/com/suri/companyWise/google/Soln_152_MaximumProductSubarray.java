package com.suri.companyWise.google;
/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

https://leetcode.com/problems/maximum-product-subarray/
 */

public class Soln_152_MaximumProductSubarray {

    public static void main(String[] args) {

        int arr1[] = {2,3,-2,4};
        System.out.println(maxProduct(arr1));

        int arr2[] = {-2,0,-1};
        System.out.println(maxProduct(arr2));
    }

    public static int maxProduct(int[] nums) {



        int maxSofar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];


        for(int i=1;i<nums.length;i++){


            int temp = Math.max(Math.max(nums[i], maxEndingHere*nums[i]),minEndingHere*nums[i]);

            minEndingHere = Math.min(Math.min(nums[i], maxEndingHere*nums[i]), minEndingHere*nums[i]);

            maxEndingHere = temp;

            if(maxEndingHere>maxSofar){
                maxSofar=maxEndingHere;
            }

        }

        return maxSofar;

    }
}
