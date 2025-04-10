package com.suri.leetcode.easy;

/**

 You are given an array of integers nums. Return the length of the longest
 subarray
 of nums which is either
 strictly increasing
 or
 strictly decreasing
 .



 Example 1:

 Input: nums = [1,4,3,3,2]

 Output: 2

 Explanation:

 The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

 The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

 Hence, we return 2.

 Example 2:

 Input: nums = [3,3,3,3]

 Output: 1

 Explanation:

 The strictly increasing subarrays of nums are [3], [3], [3], and [3].

 The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

 Hence, we return 1.

 Example 3:

 Input: nums = [3,2,1]

 Output: 3

 Explanation:

 The strictly increasing subarrays of nums are [3], [2], and [1].

 The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

 Hence, we return 3.
 https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
 */
public class Soln_3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {
    public static void main(String[] args) {
        int[] nums= {3,2,1};
        System.out.println(longestMonotonicSubarray(nums));

    }

    public static int longestMonotonicSubarray(int[] nums) {

        int maxlen =0;
        // Find longest strictly increasing subarray
        for(int i=0;i<nums.length; i++){
            int currentLen =1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]>nums[j-1]){
                    currentLen++;
                }else{
                    break;
                }
            }
            maxlen = Math.max(currentLen, maxlen);
        }

        // Find longest strictly decreasing subarray
        for(int i=0;i<nums.length; i++){
            int currentLen =1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<nums[j-1]){
                    currentLen++;
                }else{
                    break;
                }
            }
            maxlen = Math.max(currentLen, maxlen);
        }

        return maxlen;

    }
}
