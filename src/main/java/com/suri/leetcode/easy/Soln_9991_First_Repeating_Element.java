package com.suri.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*
Given an array arr[] of size n, find the first repeating element. The element should occurs more than once and the index of its first occurrence should be the smallest.

Example 1:

Input:
n = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation:
5 is appearing twice and
its first appearence is at index 2
which is less than 3 whose first
occuring index is 3.

Example 2:

Input:
n = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation:
All elements appear only once so
answer is -1.
https://practice.geeksforgeeks.org/problems/first-repeating-element4018/1/
 */
public class Soln_9991_First_Repeating_Element {

    public static void main(String[] args) {
     int arr[] = {1, 5, 3, 4, 3, 5, 6};

        System.out.println(firstRepeated(arr, arr.length));

    }
    public static int firstRepeated(int[] arr, int n) {
        Set<Integer> set = new HashSet();
        int min =-1;
        for(int i = n-1;i>=0;i--){
            if(set.contains(arr[i])){
                min =i+1;
            }
            set.add(arr[i]);
        }
        return min;
    }
}
