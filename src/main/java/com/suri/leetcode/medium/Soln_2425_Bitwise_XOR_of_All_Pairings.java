package com.suri.leetcode.medium;
/*
You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

Return the bitwise XOR of all integers in nums3.

Example 1:

Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
Output: 13
Explanation:
A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
The bitwise XOR of all these numbers is 13, so we return 13.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 0
Explanation:
All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
and nums1[1] ^ nums2[1].
Thus, one possible nums3 array is [2,5,1,6].
2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.
https://leetcode.com/problems/bitwise-xor-of-all-pairings
 */

public class Soln_2425_Bitwise_XOR_of_All_Pairings {
    public static void main(String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};
        System.out.println(xorAllNums(nums1, nums2));
    }

    public static int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int xor1 =0;
        int xor2=0;
        if(n%2!=0){
            for(int num:nums1){
                xor1^=num;
            }
        }

        if(m%2!=0){
            for(int num:nums2){
                xor2^=num;
            }
        }
        return xor1^xor2;
    }
}

/*

Time complexity: O(n+m)


Approach 2: Space Optimized Bit Manipulation
Intuition
A key observation from the previous approach is that the contribution of any element from nums1 or nums2 to the final result depends on the length of the other array:

For an element a1 in nums1, it is XOR'd with every element in nums2. So, its total contribution depends on the length of nums2 (n2).
Similarly, for an element b1 in nums2, its total contribution depends on the length of nums1 (n1).
Let’s simplify this further:

If n2 (length of nums2) is even, each element in nums1 is XOR'd an even number of times. Using the property of XOR (a ^ a = 0), all such elements cancel out and contribute 0 to the result.
If n2 is odd, each element in nums1 is XOR'd an odd number of times. Using the property that an odd number of XORs leaves the element unchanged, all elements in nums1 retain their value in the result.
The same logic applies to nums2 when considering the length of nums1.

Depending on whether n1 and n2 are even or odd, there are four possible scenarios:

Both n1 and n2 are even:
All elements in nums1 and nums2 contribute 0 to the result since their total occurrences are even.
n2 is odd, n1 is even:
Elements in nums1 occur an odd number of times and contribute to the result.
Elements in nums2 occur an even number of times and contribute 0.
Thus the answer will be XOR of all elements in nums1.
n1 is odd, n2 is even:
Elements in nums2 occur an odd number of times and contribute to the result.
Elements in nums1 occur an even number of times and contribute 0.
Thus the answer will be XOR of all elements in nums2.
Both n1 and n2 are odd:
Elements in both nums1 and nums2 occur an odd number of times and retain their value in the result.
Thus the answer will be XOR of all elements in nums1 XOR'd with XOR of all elements in nums2.
For a more comprehensive understanding of bit manipulation, check out the Bit Manipulation Explore Card 🔗. This resource provides an in-depth look at bit-level operations, explaining their key concepts and applications with a variety of problems to solidify understanding of the pattern.

Algorithm
Initialize two variables xor1 and xor2 to store the XOR results for the first and second arrays respectively, both starting at 0.
Initialize two variables len1 and len2 to store the lengths of the input arrays nums1 and nums2 respectively.
If the length of the second array nums2 is odd:
Iterate through each number in the first array nums1. For each number:
Compute its XOR with the current value of xor1.
If the length of the first array nums1 is odd:
Iterate through each number in the second array nums2. For each number:
Compute its XOR with the current value of xor2.
Compute and return the XOR of xor1 and xor2 as the final result.

 */
