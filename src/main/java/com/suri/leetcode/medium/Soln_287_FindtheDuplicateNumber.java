package com.suri.leetcode.medium;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1

https://www.youtube.com/watch?v=32Ll35mhWg0&ab_channel=takeUforward
https://leetcode.com/problems/find-the-duplicate-number/
 */
public class Soln_287_FindtheDuplicateNumber {
    public static void main(String[] args) {
        int num[] = {1,3,4,2,2};
        System.out.println(findDuplicate(num));

    }

    public static int findDuplicate(int[] nums) {
         /*
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n;i++){


            if(map.containsKey(nums[i])){
                return nums[i];
            }else{

                map.put(nums[i], 1);
            }
        }
        return 0;
        */

        int slow = nums[0];
        int fast = nums[0];

        do {

            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];

        }
        return slow;
    }
}
