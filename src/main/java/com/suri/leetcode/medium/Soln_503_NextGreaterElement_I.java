package com.suri.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/*
Given an integer array, find the next greater element for every array element. The next greater element of a number x is the first greater number to the right of x in the array.

In other words, for each element A[i] in the array A, find an element A[j] such that j > i and A[j] > A[i] and the value of j should be as minimum as possible. If the next greater element doesn’t exist in the array for any element, consider it -1.

For example,

Input:  [2, 7, 3, 5, 4, 6, 8]
Output: [7, 8, 5, 6, 6, 8, -1]


Input:  [5, 4, 3, 2, 1]
Output: [-1, -1, -1, -1, -1]


Note that the next greater element for the last array element is always -1.

https://www.techiedelight.com/next-greater-element/
 */
public class Soln_503_NextGreaterElement_I {
    public static void main(String[] args) {

        int arr[] = {2, 7, 3, 5, 4, 6, 8};
        int result[]  =findNextGreaterElements(arr);
        Arrays.stream(result).forEach(x-> System.out.print(x+" "));
    }

    public static int[] findNextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            // loop till we have a greater element on top or stack becomes empty.

            // Keep popping elements from the stack smaller than the current element, and set their next greater element to the current element

            while (!stack.isEmpty() && nums[stack.peek()] < next) {
                int index = stack.pop();
                result[index] = next;
            }
            stack.push(i);
        }

        return result;
    }
}
