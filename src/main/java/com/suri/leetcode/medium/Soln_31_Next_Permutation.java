package com.suri.leetcode.medium;

import java.util.Arrays;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory
https://leetcode.com/problems/next-permutation/
https://www.youtube.com/watch?v=ho4gTCr0QSk&t=586s
 */
public class Soln_31_Next_Permutation {
    public static void main(String[] args) {
        int arr[] = {1,3,2};
        nextPermutation(arr);

    }

    public static void nextPermutation(int[] arr) {

        int n = arr.length;
        int inftp = 0;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                inftp = i;
                break;
            }
        }

        if (inftp == 0) {
            Arrays.sort(arr, 0, arr.length);
        } else {
            int index2 = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > arr[inftp - 1]) {
                    index2 = j;
                    break;
                }
            }
            int temp = arr[inftp - 1];
            arr[inftp - 1] = arr[index2];
            arr[index2] = temp;
        }
        Arrays.sort(arr, inftp, arr.length);
        System.out.println(arr);

    }
}
