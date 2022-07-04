package com.suri.leetcode.medium;

import java.util.ArrayList;

/*

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Soln_34_FindFirstAndLastPositionOfElement {
    public static void main(String[] args) {

        int arr1[] = {1, 3, 5, 5, 5, 5};
        int res[]= searchRange(arr1,5);
        System.out.println(res[0]+"----"+res[1]);

    }

    public static int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0]=-1;
        result[1]=-1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                result[0]= mid;
                //continue seraching in left part
                r = mid-1;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r= mid-1;
            }
        }

        l=0;
        r= nums.length-1;

        while(l<=r){

            int mid = l+(r-l)/2;

            if(nums[mid] == target){
                result[1]= mid;
                //continue seraching in right part
                l= mid+1;

            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r= mid-1;
            }
        }
        return result;

    }
}
