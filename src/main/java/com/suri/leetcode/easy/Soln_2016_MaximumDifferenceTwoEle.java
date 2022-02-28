package com.suri.leetcode.easy;

/*
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
https://leetcode.com/problems/maximum-difference-between-increasing-elements/

 */
public class Soln_2016_MaximumDifferenceTwoEle {
    public static void main(String[] args) {

        int arr[] = {999,997,980,976,948,940,938,928,924,917,907,907,881,878,864,862,859,857,848,840,824,824,824,805,802,798,788,777,775,766,755,748,735,732,727,705,700,697,693,679,676,644,634,624,599,596,588,583,562,558,553,539,537,536,509,491,485,483,454,449,438,425,403,368,345,327,287,285,270,263,255,248,235,234,224,221,201,189,187,183,179,168,155,153,150,144,107,102,102,87,80,57,55,49,48,45,26,26,23,15};

        int arr1[]= {9,4,3,2};

        //System.out.println(maximumDifference(arr));

        System.out.println(maximumDifference(arr1));
    }

    public static int maximumDifference(int[] nums) {
        int max_diff = -1;
        int minElement = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - minElement > max_diff) {
                max_diff = nums[i] - minElement;
            }
            if (nums[i] < minElement) {
                minElement = nums[i];
            }
        }
        return max_diff != 0 ? max_diff : -1;
    }

    public static int maximumDifference2(int arr[]) {
        int min = arr[0];
        int diff = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > min) {
                diff = Math.max(arr[i] - min, diff);
            }
            min = Math.min(arr[i], min);
        }
        return diff;
    }
}
