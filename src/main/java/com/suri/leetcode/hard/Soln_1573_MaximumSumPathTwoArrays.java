package com.suri.leetcode.hard;

/*
Get the Maximum Score/Maximum Sum Path in Two Arrays

Given two sorted arrays, such that the arrays may have some common elements. Find the sum of the maximum sum path to reach from the beginning of any array to end of any of the two arrays. We can switch from one array to another array only at common elements.
Note: The common elements do not have to be at the same indexes.

Examples:

Input: ar1[] = {2, 3, 7, 10, 12}
       ar2[] = {1, 5, 7, 8}
Output: 35

Explanation: 35 is sum of 1 + 5 + 7 + 10 + 12.
We start from the first element of arr2 which is 1, then we
move to 5, then 7.  From 7, we switch to ar1 (as 7 is common)
and traverse 10 and 12.

Input: ar1[] = {10, 12}
       ar2 = {5, 7, 9}
Output: 22

Explanation: 22 is the sum of 10 and 12.
Since there is no common element, we need to take all
elements from the array with more sum.

Input: ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}
        ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}
Output: 122

Explanation: 122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34

https://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
https://leetcode.com/problems/get-the-maximum-score/

 */
public class Soln_1573_MaximumSumPathTwoArrays {
    public static void main(String[] args) {

        int nums1[] ={2,4,5,8,10};
        int nums2[] = {4,6,8,9};
        System.out.println(maxSum(nums1, nums2));

        int nums11[] ={1,3,5,7,9};
        int nums12[] = {3,5,100};
        System.out.println(maxSum(nums11, nums12));
       /* int nums1[] ={1,2,3,4,5};
        int nums2[] = {6,7,8,9,10};
        System.out.println(maxSum(nums1, nums2));

        int nums1[] ={1,4,5,8,9,11,19};
        int nums2[] = {2,3,4,11,12};
        System.out.println(maxSum(nums1, nums2));*/
    }

    public static int maxSum(int[] nums1, int[] nums2) {
        long maxSum = 0;
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                maxSum += Math.max(sum1, sum2) + nums1[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        while (i < m) {
            sum1 += nums1[i++];
        }
        while (j < n) {
            sum2 += nums2[j++];
        }
        maxSum += Math.max(sum1, sum2);
        return (int) (maxSum % (int) (Math.pow(10, 9) + 7));
    }

}
