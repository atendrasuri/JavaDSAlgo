package com.suri.leetcode.easy;



/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:

Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.

https://leetcode.com/problems/missing-number/

 */
public class Soln_268_Missing_Number {

    public static void main(String[] args) {
        int nums[]={9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int count=0;
        int sumCount =0;
        for(int i=0;i<nums.length;i++){
            count+=i;
            sumCount+=nums[i];
        }
        count+=nums.length;
        return count-sumCount;
    }

    public static int missingNumber_I(int[] nums) {

        int xor1=0;
        int xor2 =0;

        for(int i=0;i<nums.length;i++){
            xor1^=nums[i];
        }

        int n = nums.length+1;

        for(int i=1;i<=n;i++){
            xor2^= i;
        }
        return xor1^xor2;

    }
}
