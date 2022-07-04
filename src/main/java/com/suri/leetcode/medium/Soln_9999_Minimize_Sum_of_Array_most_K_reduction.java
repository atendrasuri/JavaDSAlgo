package com.suri.leetcode.medium;

import java.util.PriorityQueue;

/*
Given an array of integers arr[] consisting of N integers, the task is to minimize the sum of the given array by performing at most K operations, where each operation involves reducing an array element arr[i] to floor(arr[i]/2).

Examples :

Input: N = 4, a[] = {20, 7, 5, 4}, K = 3
Output: 17
Explanation:
Operation 1: {20, 7, 5, 4} -> {10, 7, 5, 4}
Operation 2: {10, 7, 5, 4} -> {5, 7, 5, 4}
Operation 3: {5, 7, 5, 4} -> {5, 3, 5, 4}
No further operation can be performed. Therefore, sum of the array = 17.

Input: N = 4, a[] = {10, 4, 6, 16}, K = 2
Output: 23

https://www.geeksforgeeks.org/minimize-sum-of-an-array-by-at-most-k-reductions/
 */
public class Soln_9999_Minimize_Sum_of_Array_most_K_reduction {
    public static void main(String[] args) {

        int arr1[] = {20, 7, 5, 4};
        System.out.println(minSum(arr1, arr1.length, 3));

        int arr2[] = {10, 4, 6, 16};
        System.out.println(minSum(arr2, arr2.length, 2));
    }

    public static int minSum(int arr[], int n, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }
        while (!maxHeap.isEmpty() && k > 0) {
            int maxElement = maxHeap.remove();
            maxHeap.add(maxElement / 2);
            k--;
        }
        int minSum = 0;
        while (!maxHeap.isEmpty()) {
            minSum += maxHeap.remove();
        }
        return minSum;
    }

}
