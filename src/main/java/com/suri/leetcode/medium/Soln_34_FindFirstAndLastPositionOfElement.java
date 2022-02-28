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
        System.out.println(firstAndLast(arr1, 6,5));

    }

    public static ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        ArrayList<Integer> result = new ArrayList<>();
        int l =0;
        int r=n-1;
        int firstIndex=-1;
        int lastIndex=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if( arr[mid]==x){
                firstIndex = mid;
                //continue searching left part
                r= mid-1;
            }else if(x<=arr[mid]){
                r= mid-1;
            }else{
                l = mid+1;
            }
        }
        l=0;
        r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==x){
                lastIndex = mid;
                //continue searching right part
                l = mid+1;
            }else if(x>=arr[mid]){
                l = mid+1;
            }else{
                r=mid-1;
            }
        }

        result.add(firstIndex);

        result.add(lastIndex);

        return result;
    }
}
