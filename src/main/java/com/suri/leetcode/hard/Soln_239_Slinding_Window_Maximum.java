package com.suri.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]

https://leetcode.com/problems/sliding-window-maximum/
https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
public class Soln_239_Slinding_Window_Maximum {
    public static void main(String[] args) {

        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(maxSlidingWindow1(arr, k));
        System.out.println(maxSlidingWindow2(arr, k));

        int arr1[]= {1};

        System.out.println(maxSlidingWindow1(arr1, 1));
        System.out.println(maxSlidingWindow2(arr1, 1));

    }

    public static List<Integer> maxSlidingWindow1(int arr[], int k) {
        List<Integer> result = new ArrayList<>();
        if (arr.length == 0) {
            return result;
        }
        List<Integer> window = new ArrayList<>();
        // first add k elements
        for (int i = 0; i < k; i++) {
            window.add(arr[i]);
        }
        //do for N-k elements
        for (int i = k; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < window.size(); j++) {
                max = Math.max(max, window.get(j));
            }
            result.add(max);
            window.remove(0);
            window.add(arr[i]);
        }

        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < window.size(); i++) {
            temp = Math.max(window.get(i), temp);
        }
        result.add(temp);
        return result;
    }

    //approach 2- optimized way
    public static List<Integer> maxSlidingWindow2(int arr[], int k) {

        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            // remove all useless elements present at the front of the list
            while (!list.isEmpty() &&  arr[i]> arr[list.getLast()]) {
                list.removeLast();
            }
            // add index of current element at the back
            list.add(i);
        }


        for (int i = k; i < arr.length; i++) {
            // first element present in the list is the greatest element for the last 'k' sized sub-array
            result.add(arr[list.getFirst()]);

            // now remove all indices of elements from the list which do not belong to current window
            while (!list.isEmpty() && list.getFirst() < (i - k + 1)) {
                list.removeFirst();
            }

            // now again remove all useless elements present at the front of the list
            // remove all useless elements present at the front of the list
            while (!list.isEmpty() && arr[i]> arr[list.getLast()] ) {
                list.removeLast();
            }
            // and finally insert this new element at the back of the list
            list.add(i);
        }
        // now print the largest element from the last sub-array(window)
        result.add(arr[list.getFirst()]);
        return result;
    }

}
