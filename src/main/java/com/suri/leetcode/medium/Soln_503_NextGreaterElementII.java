package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
https://leetcode.com/problems/next-greater-element-ii/
https://www.geeksforgeeks.org/next-greater-element/

 */
public class Soln_503_NextGreaterElementII {
    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        System.out.println(nextGreaterElements(arr));

    }

    public static List<Integer> nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int next = nums[i];
            while ((!stack.isEmpty()) && (stack.firstElement() < next)) {
                result.add(next);
                stack.pop();
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            result.add(-1);
            stack.pop();
        }
        return result;
    }
}
