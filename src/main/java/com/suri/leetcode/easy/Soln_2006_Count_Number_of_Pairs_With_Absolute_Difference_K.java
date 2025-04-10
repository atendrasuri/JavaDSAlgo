package com.suri.leetcode.easy;
/*
Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.


Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
Example 2:

Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.
Example 3:

Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4]


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k
 */

import java.util.HashMap;
import java.util.Map;

public class Soln_2006_Count_Number_of_Pairs_With_Absolute_Difference_K {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int k=1;
        System.out.println(countKDifference1(nums, k));
        System.out.println(countKDifference2(nums, k));


    }

    public static int countKDifference1(int[] nums, int k) {
        int[] count =  new int[101];
        int result =0;
        for(int num:nums){
            count[num]++;
        }
        for(int i=k+1;i<=100;i++){
            result+= count[i]*count[i-k];
        }
        return result;

    }

    public static int countKDifference2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int result =0;

        for(int i=0;i<nums.length;i++){

            result+= map.getOrDefault(nums[i]-k, 0);
            result+= map.getOrDefault(nums[i]+k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        return result;

    }
}
