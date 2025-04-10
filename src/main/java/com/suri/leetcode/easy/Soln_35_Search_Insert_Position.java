package com.suri.leetcode.easy;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

https://leetcode.com/problems/search-insert-position/
 */
public class Soln_35_Search_Insert_Position {
    public static void main(String[] args) {

        int arr1[] = {1,3,5,6};
        System.out.println(searchInsert(arr1, 5));
        int arr2[] = {1,3,5,6};
        System.out.println(searchInsert(arr2, 2));

    }
    public  static int searchInsert(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;
        int mid=0;
        while(l<=r){

            mid = l+(r-l)/2;

            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;

    }
}
