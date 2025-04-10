package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Soln_503_NextGreaterElement_II {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};

        int result [] = nextGreaterElementsII(arr);

        for(int a:result){
            System.out.print(a+" ");
        }
    }

    public static int [] nextGreaterElementsII(int[] nums) {

        int result[] = new int[nums.length];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        int n = nums.length;

        for(int i=0; i<n*2;i++){

            int index = i%n;

            int next = nums[index];

            while(!stack.isEmpty() && nums[stack.peek()]<next){

                int prevIndex = stack.pop();
                result[prevIndex] = next;
            }
            stack.push(index);

        }
        return result;
    }
}

/*
Complexity Analysis
Time complexity : O(n). Only two traversals of the nums array are done. Further, at most 2n elements are pushed and popped from the stack.

Space complexity : O(n). A stack of size n is used. res array of size n is used.
 */
