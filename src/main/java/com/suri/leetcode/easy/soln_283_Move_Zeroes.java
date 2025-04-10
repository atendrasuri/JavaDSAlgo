package com.suri.leetcode.easy;

import java.sql.SQLOutput;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
https://leetcode.com/problems/move-zeroes
 */
public class soln_283_Move_Zeroes {
    public static void main(String[] args) {

        int arr[] = {0,1,0,3,12};
        moveZeroes(arr);
        IntStream.of(arr).forEach(a-> System.out.print(a+" "));
    }

    public static void moveZeroes1(int[] nums) {

        int j=0;

        for(int i=0;i<nums.length;i++){

            if(nums[i]!=0){
                int temp = nums[i];
                nums[i]= nums[j];
                nums[j]= temp;
                j++;
            }
        }


    }
    public static void moveZeroes(int[] nums) {
        int count =0;
        int i =0;
        while(i<nums.length){
            if(nums[i]!=0){
                int temp = nums[count];
                nums[count]= nums[i];
                nums[i]= temp;
                count++;
            }
            i++;
        }
    }
}
