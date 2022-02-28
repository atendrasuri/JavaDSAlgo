package com.suri.leetcode.easy;

import java.util.Arrays;

/*
Given a binary array A[] of size N. The task is to arrange the array in increasing order.
Note: The binary array contains only 0  and 1

https://practice.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1
https://www.youtube.com/watch?v=jFrUwjx4eoA&ab_channel=Pepcoding

 */
public class Soln_Segregate1n0 {
    public static void main(String[] args) {

        int arr[] = {0,1,0,0,1,1,0,0};
        binSort(arr, arr.length);
        Arrays.stream(arr).forEach(e-> System.out.print(e +" "));


    }

    public static void binSort(int arr[], int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j = j + 1;
            }
        }
    }
}
