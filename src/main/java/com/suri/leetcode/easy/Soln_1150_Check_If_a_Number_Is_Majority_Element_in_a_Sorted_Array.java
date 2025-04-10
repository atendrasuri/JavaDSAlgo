package com.suri.leetcode.easy;

/**

 Given an integer array nums sorted in non-decreasing order and an integer target, return true if target is a majority element, or false otherwise.

 A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.



 Example 1:

 Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
 Output: true
 Explanation: The value 5 appears 5 times and the length of the array is 9.
 Thus, 5 is a majority element because 5 > 9/2 is true.
 Example 2:

 Input: nums = [10,100,101,101], target = 101
 Output: false
 Explanation: The value 101 appears 2 times and the length of the array is 4.
 Thus, 101 is not a majority element because 2 > 4/2 is false.

 https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array

 */

public class Soln_1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array {

    public static void main(String[] args) {

        int[] nums=  {2,4,5,5,5,5,5,6,6};
        int target = 5;
        System.out.println(isMajorityElement(nums, target));
    }

    public static boolean isMajorityElement(int[] nums, int target) {
        int l =0;
        int r= nums.length-1;
        int firstIndex =-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                firstIndex =mid;
                r= mid-1;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r= mid-1;
            }
        }
        l =0;
        r= nums.length-1;
        int lastIndex =-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                lastIndex =mid;
                l= mid+1;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r= mid-1;
            }
        }

        if(firstIndex !=-1 && lastIndex!=-1){
            if((lastIndex-firstIndex +1) > (nums.length/2)){
                return true;
            }
        }
        return false;



    }
}
