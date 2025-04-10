package com.suri.leetcode.medium;

import java.util.PriorityQueue;

/*

You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:

Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
Return the total number of continuous subarrays.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [5,4,2,4]
Output: 8
Explanation:
Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
There are no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.


Example 2:

Input: nums = [1,2,3]
Output: 6
Explanation:
Continuous subarray of size 1: [1], [2], [3].
Continuous subarray of size 2: [1,2], [2,3].
Continuous subarray of size 3: [1,2,3].
Total continuous subarrays = 3 + 2 + 1 = 6.
https://leetcode.com/problems/continuous-subarrays
 */
public class Soln_2762_Continuous_Subarrays {
    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));

    }

    public static long continuousSubarrays(int[] nums) {

        int left=0, right=0;

        int count =0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)->nums[a]-nums[b]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->nums[b]-nums[a]);

        while(right<nums.length){
            minHeap.add(right);
            maxHeap.add(right);

            while(left<right && nums[maxHeap.peek()]-nums[minHeap.peek()]>2){
                left++;

                while(!maxHeap.isEmpty() && maxHeap.peek()<left){
                    maxHeap.remove();
                }
                while(!minHeap.isEmpty() && minHeap.peek()<left){
                    minHeap.remove();
                }
            }
            count+= right-left+1;
            right++;
        }
        return count;

    }
}
