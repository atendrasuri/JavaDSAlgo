package com.suri.leetcode.medium;
/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.



Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

https://leetcode.com/problems/increasing-triplet-subsequence

Algorithm:

Let's take a look at two cases where nums is sorted:

If nums is sorted in descending order, you will always end up in this first if block (and thus, repeatedly updating first_num). Finally, False will be returned after the loop has been terminated.
If nums is sorted in ascending order, you will first update first_num as soon as you see the first number in nums and when you encounter another number in nums, you will update the second_nums since this new number would be bigger than the value stored in first_num. After these two variables have been populated, all you need to look for is another number which is bigger than first_num and second_num. As soon as you find that number, the first if and the second else if blocks will be skipped, and you will end up in the last else block and True will be returned immediately.
This works not only for sorted cases described above but also for cases where the numbers are unsorted. First, find the smallest number and store it in first_num, and then find the second smallest number and store it in second_num. However, there is no guarantee that another number you encounter in nums will be greater than first_num and second_num. This new number can even be smaller than then first_num (in that case, you will have to update first_num with this new value) or second_num (in that case, you will have to update second_num with this new value). As long as you encounter those cases, you keep on updating your first_num and second_num. As soon as you encounter a number which is greater than both first_num and second_num, you have found your last number to complete the increasing triplet subsequence. At that point, you can immediately return True
 */
public class Soln_334_Increasing_Triplet_Subsequence {
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {

        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;

        for(int num: nums){

            if(num<=first_num){
                first_num = num;
            }else if(num<=second_num){
                second_num = num;
            }else{
                return true;
            }
        }
        return false;

    }
}
