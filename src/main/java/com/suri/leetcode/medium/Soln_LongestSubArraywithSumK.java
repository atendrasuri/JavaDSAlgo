package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
/*
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

Example 1:
Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.

Example 2:

Input :
A[] = {-1, 2, 3}
K = 6
Output : 0

https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */

public class Soln_LongestSubArraywithSumK {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1, 9};
        int k=15;
        System.out.println(lenOfLongSubarr(arr, arr.length, k));

    }

    public static int lenOfLongSubarr(int arr[], int n, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == k) {
                maxlen = i + 1;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                int currlen = i - map.get(sum - k);
                if (currlen > maxlen) {
                    maxlen = currlen;
                }
            }
        }
        return maxlen;
    }

    public static int lenOfLongSubarr1(int arr[], int n, int k) {
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;

    }
}
