package com.suri.leetcode.medium;

/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
https://leetcode.com/problems/jump-game/


Start from the first index.
Maintain a variable maxReach which keeps track of the farthest index that can be reached at any given moment.
For each index i, if i is reachable (i <= maxReach), then update maxReach as the maximum of the current maxReach and i + nums[i] (the farthest point reachable from index i).
If at any point maxReach becomes greater than or equal to the last index, return True.
If the loop ends and maxReach is still less than the last index, return False.
https://www.youtube.com/watch?v=tZAa_jJ3SwQ&ab_channel=takeUforward
 */
public class Soln_55_Jump_Game {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maximumJumpCanTake = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maximumJumpCanTake) {
                return false;
            }
            //System.out.println("i = "+i+" jum = "+jump);
            maximumJumpCanTake = Math.max(maximumJumpCanTake, nums[i] + i);
            //System.out.println(" jum = "+jump+" nums[i]+i+" + nums[i]+i);
        }
        return false;

    }
}

/**
 1. Approach here is if the Array contains 0 and if we are able to cross the 0 then we can reach the end of the Array.
 2. If Array doesn't contain 0 then we always reach end of the index.

 */
