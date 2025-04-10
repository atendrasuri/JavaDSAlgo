package com.suri.leetcode.medium;
/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
https://leetcode.com/problems/single-element-in-a-sorted-array
 */
public class Soln_540_Single_Element_in_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        int l =0;
        int h = nums.length-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(mid%2==1){
                mid--;
            }
            if(nums[mid]==nums[mid+1]){
                l = mid+2;
            }else{
                h = mid;
            }
        }
        return nums[l];

    }
}
