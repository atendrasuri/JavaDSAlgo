package com.suri.leetcode.easy;

/*

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

https://leetcode.com/problems/valid-mountain-array/
https://www.enjoyalgorithms.com/blog/valid-mountain-array
 */
public class Soln_941_ValidMountainArray {
    public static void main(String[] args) {

        int arr1[] ={1,2,4,5,4,3};
        System.out.println(validMountainArray(arr1));

        int arr2[] ={1,2,3,4,5,4,6,4,3};
        System.out.println(validMountainArray(arr2));
    }
    public static boolean validMountainArray(int[] arr) {

        int i =0;
        int n = arr.length;
        while(i<n-1 && arr[i]<arr[i+1]){
            i++;
        }
        if(i==0 || i==n-1){
            return false;
        }
        while(i<n-1 && arr[i]>arr[i+1]){
            i++;
        }
        if(i==n-1){
            return true;
        }
        return false;

    }
}

