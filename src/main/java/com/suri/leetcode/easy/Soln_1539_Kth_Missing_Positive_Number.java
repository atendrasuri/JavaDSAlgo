package com.suri.leetcode.easy;
/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.



Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
https://leetcode.com/problems/kth-missing-positive-number/

Algorithms:

Iterate through each number num in the array arr:

If the current num is less than or equal to k, increment k.
This step accounts for the missing positive integers. If the number is less than or equal to k, it means we've encountered an actual element of the sequence, so the k-th missing positive integer is pushed further by one.
If the current num is greater than k, break out of the loop.
This happens because there’s no need to continue iterating once we’ve passed the range where the k-th missing integer could exist.
Return the updated value of k as the final result, which represents the k-th missing positive integer
 */

public class Soln_1539_Kth_Missing_Positive_Number {
    public static void main(String[] args) {

        int[] nums = {2,3,4,7,11};
        int k=5;
        System.out.println(findKthPositive(nums, k));

    }
    public static int findKthPositive(int[] nums, int k) {
        for(int num:nums){
            if(num<=k){
                k++;
            }else{
                break;
            }
        }
        return k;

    }
}
