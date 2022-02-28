package com.suri.leetcode.medium;

import java.util.Arrays;

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

https://leetcode.com/problems/sort-colors/
https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
https://www.youtube.com/watch?v=MbV26HWqxrs&ab_channel=Pepcoding
 */
public class Soln_75_01n2 {
    public static void main(String[] args) {

        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(e-> System.out.print(e +" "));

    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int j = 0; // 0 to j-1 0's area
        int i = 0; // j to 1-1 1's area
        int k = n - 1; // k+1 to end 2's area

        while (i <= k) {
            if (nums[i] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
            }
        }
    }
}
