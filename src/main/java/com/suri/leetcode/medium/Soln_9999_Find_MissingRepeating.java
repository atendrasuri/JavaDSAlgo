package com.suri.leetcode.medium;

import java.util.Arrays;

/*
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and
smallest positive missing number is 2.
https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 */
public class Soln_9999_Find_MissingRepeating {
    public static void main(String[] args) {

        int arr[] ={1, 3, 3};
        arr = findTwoElement(arr, arr.length);
        Arrays.stream(arr).forEach(x-> System.out.println(x));

    }
   public static int[] findTwoElement(int arr[], int n) {
        int result[] = new int[2];
        for(int i=0;i<n;i++){
            int abs_val = Math.abs(arr[i]);
            if(arr[abs_val-1]>0){
                arr[abs_val-1]= - arr[abs_val-1];
            }else{
                result[0]=  abs_val;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                result[1]= i+1;
            }
        }
        return result;
    }
}
