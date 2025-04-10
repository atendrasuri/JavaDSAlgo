package com.suri.leetcode.easy;
/*
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

https://leetcode.com/problems/check-if-n-and-its-double-exist
 */

import java.util.Arrays;

public class Soln_1346_Check_If_N_and_Its_Double_Exist {
    public static void main(String[] args) {
        int [] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));

    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){

            int target = 2*arr[i];

            int index = myBinarySearch(arr, target);
            if(index>=0 && index!=i){
                return true;
            }
        }
        return false;

    }

    public static int myBinarySearch(int arr[], int target){
        int l=0;
        int r = arr.length-1;

        while(l<=r){
            int mid = (l+r)/2;

            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                l= mid+1;
            }else{
                r= mid-1;
            }
        }
        return -1;
    }
}
