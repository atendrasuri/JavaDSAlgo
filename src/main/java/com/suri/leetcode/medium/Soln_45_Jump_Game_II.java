package com.suri.leetcode.medium;

import java.util.Arrays;

/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
https://leetcode.com/problems/jump-game-ii/
https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
https://www.youtube.com/watch?v=phgjL7SbsWs&t=1081s&ab_channel=Pepcoding

 */

public class Soln_45_Jump_Game_II {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        System.out.println(jump(arr));

        int arr2[] ={1, 2, 0, 3,0 ,0};
        System.out.println(jump(arr2));

    }

    public static int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 0;
        for(int i= nums.length-2;i>=0;i--){
            int steps = nums[i];
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=steps && (i+j)<nums.length;j++){

                if(dp[i+j]!=-1 && dp[i+j]<min){
                    min = dp[i+j];
                }
            }
            if(min!= Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
}
