package com.suri.leetcode.medium;
/*
You are given an integer array nums. This array contains n elements, where exactly n - 2 elements are special numbers. One of the remaining two elements is the sum of these special numbers, and the other is an outlier.

An outlier is defined as a number that is neither one of the original special numbers nor the element representing the sum of those numbers.

Note that special numbers, the sum element, and the outlier must have distinct indices, but may share the same value.

Return the largest potential outlier in nums

Example 1:

Input: nums = [2,3,5,10]

Output: 10

Explanation:

The special numbers could be 2 and 3, thus making their sum 5 and the outlier 10.

Example 2:

Input: nums = [-2,-1,-3,-6,4]

Output: 4

Explanation:

The special numbers could be -2, -1, and -3, thus making their sum -6 and the outlier 4.

Example 3:

Input: nums = [1,1,1,1,1,5,5]

Output: 5

Explanation:

The special numbers could be 1, 1, 1, 1, and 1, thus making their sum 5 and the other 5 as the outlier.
https://leetcode.com/problems/identify-the-largest-outlier-in-an-array
 */

import java.util.HashMap;
import java.util.Map;

public class Soln_3371_Identify_the_Largest_Outlier_in_an_Array {

    public static void main(String[] args) {

    }

    public int getLargestOutlier(int[] nums) {
        int totalSum =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            totalSum+= num;
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int largestOutlier = Integer.MIN_VALUE;

        for(int num: map.keySet()){

            int potentialOutlier = totalSum - 2*num;

            if(map.containsKey(potentialOutlier)){

                if(potentialOutlier!= num || map.get(num)>1){
                    largestOutlier = Math.max(largestOutlier, potentialOutlier);
                }
            }
        }
        return largestOutlier;

    }
}

/*
Intuition

To solve this problem, we need to find the largest potential outlier in an array where:

( n - 2 ) elements are special numbers.
One element is the sum of the special numbers.
One element is the outlier, which is distinct from both the sum element and the special numbers.
The problem hints that we can leverage the relationship between the sum of all elements and the sum of special numbers. Specifically, the sum of all elements in the array is related to the sum of the special numbers, their sum, and the outlier. This relationship can be described by the equation:

total_sum=2×(sum of special numbers)+(outlier)

The task is to find the largest outlier, given that there is one candidate that is the sum of the special numbers and the rest are special numbers.

Approach
To solve this efficiently, I’ll break down the approach as follows:

Calculate the Total Sum of All Elements:
First, compute the sum of all elements in the array (total_sum). This will help us later in identifying potential outliers.

Count Frequencies of Elements:
Use a dictionary (num_counts) to track the frequency of each number in the array. This helps in quickly checking whether a number exists in the array when needed.

Identify Possible Outliers:
For each unique number num in the array, treat it as a candidate for the sum of the special numbers. The potential outlier is calculated using the formula:
potential_outlier=total_sum−2×num
This formula comes from the equation:
outlier=total_sum−2×sum of special numbers

Check Validity of Potential Outlier:
For each candidate number, check if the calculated potential outlier exists in the array. Ensure that the outlier is distinct from the candidate number, unless the candidate appears multiple times in the array.

Track the Largest Outlier:
Throughout the iteration, keep track of the largest valid outlier and return that as the result.


Complexity
Time complexity:

Calculating the total sum: (O(n)), where (n) is the number of elements in the array.
Constructing the frequency map: (O(n)).
Iterating over the unique keys in the frequency map: (O(m)), where (m) is the number of unique elements, and (m \leq n).
Therefore, the overall time complexity is (O(n)).
Space complexity:
The space complexity is dominated by the space used for the frequency map, which stores the count of each unique number. Hence, the space complexity is (O(m)), where (m) is the number of unique elements in the array.

 */
