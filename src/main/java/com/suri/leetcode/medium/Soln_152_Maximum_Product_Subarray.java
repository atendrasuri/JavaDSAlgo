package com.suri.leetcode.medium;

/*

Given an integer array nums, find a
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



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
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
https://leetcode.com/problems/maximum-product-subarray/description/

 */

public class Soln_152_Maximum_Product_Subarray {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {

        int maxsofar = nums[0];
        int currentmax = nums[0];
        int currentmin = nums[0];
        for(int i =1;i<nums.length; i++){

            int temp = Math.max(currentmax*nums[i], Math.max(nums[i], currentmin*nums[i]));

            currentmin = Math.min(currentmin*nums[i], Math.min(nums[i], currentmax*nums[i]));

            currentmax = temp;

            maxsofar = Math.max(currentmax, maxsofar);
        }
        return maxsofar;

    }

}
