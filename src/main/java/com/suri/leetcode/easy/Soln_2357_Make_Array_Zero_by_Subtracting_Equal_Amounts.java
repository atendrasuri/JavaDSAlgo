package com.suri.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*
You are given a non-negative integer array nums. In one operation, you must:

Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
Subtract x from every positive element in nums.
Return the minimum number of operations to make every element in nums equal to 0.

Example 1:

Input: nums = [1,5,0,3,5]
Output: 3
Explanation:
In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
Example 2:

Input: nums = [0]
Output: 0
Explanation: Each element in nums is already 0 so no operations are needed.
https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts

Number of unique element determine the number of operations because if the numbers present in the array are same would become zero in a single operation.

Approach
Using HasSet we can approach the solution by adding the non-zero elements.

Complexity
Time complexity:
O(nums.length)

Space complexity:

 */

public class Soln_2357_Make_Array_Zero_by_Subtracting_Equal_Amounts {
    public static void main(String[] args) {
        int nums[] = {1,5,0,3,5};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            set.add(nums[i]);
        }
        return set.size();
    }

}
