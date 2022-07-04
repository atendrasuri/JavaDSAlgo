package com.suri.leetcode.medium;

/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

https://leetcode.com/problems/search-in-rotated-sorted-array/
https://www.youtube.com/watch?v=1uu3g_uu8O0&t=246s&ab_channel=Pepcoding
 */
public class Soln_33_Search_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
       /* int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;*/
        /*int nums[] = {1, 3};
        int target = 3;*/
        /*int nums[] = {1,3};
        int target =2;*/
        /*int nums[] = {3,1};
        int target =3;*/

        int nums[]={5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target =3;
        System.out.println(searchMostOptimizedSol(nums, target));

        //System.out.println(searchInSortedAndRotated(nums, target));

        /*int arr1[] ={4,5,6,7,0,1,2};

        int arr11[] ={3,1};
        System.out.println(new Soln_33_Search_in_Rotated_Sorted_Array().search(arr11, 0, arr11.length-1, 3));*/
    }



    public static int searchMostOptimizedSol(int[] nums, int target) {

        int low =0;
        int high = nums.length-1;
        while(low<=high){

            int mid = (low+high)/2;

            if(nums[mid]== target){
                return mid;
            }
            // if from low to mid is sorted array
            if(nums[low]<=nums[mid]){

                // that means target present in range of [low, mid]
                if(target>=nums[low] && target<nums[mid]){

                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // if from mid to high is sorted array
            else if(nums[mid]<=nums[high]){
                // that means target present in range of [mid, high]
                if(target>nums[mid] && target<= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }

        }
        return -1;

    }

    public static int search(int[] arr, int target) {

        int pivot = getPivot(arr);
        if (arr[0] > target || pivot == 0) {
            return binarySearch(arr, pivot, arr.length - 1, target);
        } else {
            return binarySearch(arr, 0, pivot - 1, target);
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int getPivot(int[] arr) {
        int start = 0, end = arr.length - 1, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[0] > arr[mid]) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int searchInSortedAndRotated(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //the left side is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // the right side is sorted
            else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    int search(int arr[], int l, int h, int key)
    {// Complete this function
        int pivot = findPivot(arr, l,h);
        if(arr[pivot]==key){
            return pivot;
        }
        if(arr[0] > key || pivot == 0){

            return  binarySearch1(arr, pivot, h, key);
        }else {
            return  binarySearch1(arr, 0, pivot-1, key);
        }

    }

    public int findPivot(int arr[], int l, int h){
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]>arr[mid+1]){
                return mid+1;
            }
            if(arr[h]<arr[mid]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return 0;
    }


    public int binarySearch1(int arr[], int l, int h, int key){


        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==key){
                return mid;
            }

            if(key>arr[mid]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return -1;

    }
}
