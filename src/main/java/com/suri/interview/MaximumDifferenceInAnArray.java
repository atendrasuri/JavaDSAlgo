package com.suri.interview;

/*

Give an array of integers, compute the maximum difference between any item and any lower indexed smaller item for all possible pairs. In other words, for the array arr, find the maximum value of arr[j] - arr[i] for all i, j where 0 <= i < j < n and arr[i] < arr[j]. If no item has a smaller item with a lower index, then return -1.

For example, given arr = [1,2,6,4], first compare 2 to the elements to its left. 1 is smaller, so calculate the difference 2 - 1 = 1. 6 is bigger than 2 and 1, so calculate the difference 6 - 2 = 4 and 6 - 1 = 5. The last element, 4, is only bigger than 2 and 1, and the difference are 4 - 2 = 2 and 4 - 1 = 3. The largest difference is 6 - 1 = 5.

Function Description

Complete the function maxDifference. The function must return an integer that represents the maximum difference in arr.
https://stackoverflow.com/questions/57325024/maximum-difference-in-an-array-not-passing-all-test-cases-in-hackerrank/57325848#57325848

 */
public class MaximumDifferenceInAnArray {
    public static void main(String[] args) {

        int arr[] = {1,2,6,4};
        System.out.println(maximumDifference(arr));
    }

    public static int maximumDifference(int arr[]) {
        int min = arr[0];
        int diff = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > min) {
                diff = Math.max(arr[i] - min, diff);
            }
            min = Math.min(arr[i], min);
        }
        return diff;
    }
}
