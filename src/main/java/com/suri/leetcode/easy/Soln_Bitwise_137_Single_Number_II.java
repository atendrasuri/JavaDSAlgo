package com.suri.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
https://leetcode.com/problems/single-number-ii


How many bits do we have to iterate?
For this, let's look at the constraints. It is given that −2
31
 ≤nums[i]<2
31
 . Now, since integers can be negative, and different programming languages have different ways of representing negative integers, implementing this solution will be different for different languages. If we assume that negative integers are represented in 2's complement, then the number of bits will be 32. So, we will iterate 32 times.

How to get the i
th
  bit of an integer? Can we use any bitwise operator? Let's simplify

How to get the 0
th
  bit of an integer?
The 0
th
  bit of an integer is the last bit of the binary representation of the integer, often called the least significant bit. To get the last bit of an integer, we can use the bitwise AND (&) operator with 1. This 1 is internally 0000....000001. So, bit-wise AND-ing, due to its property of x&0=0 will turn off all bits except the last bit. And due to the property of x&1=x, the last bit will remain as it is. Thus, we will get the last bit of the integer.

So, if we want to get the i
th
  bit of an integer, we can right shift (>>) the integer by i bits, and then AND it with 1. This will give us the i
th
  bit of the integer. Right shifting will bring the i
th
  bit to the 0
th
  position, and then AND-ing with 1 will give us the i
th
  bit.

This in code, for num in nums, code will look like this

bit = (num >> shift) & 1
where shift is the value of i. For a particular shift, we can iterate over all integers in nums and sum them to get the i
th
  bit of the loner.

Let bitSum be the sum of i
th
  bits of all integers in nums. Then, the i
th
  bit of the loner will be bitSum % 3. Note that because of problem constraints, bitSum % 3 will be either 0 or 1. All triplets would ultimately boil down to 0 after ADD-ing and MOD-ing. So, if bitSum % 3 is 0, it means that the i
th
  bit of the loner was not set. If it is 1, it means that the i
th
  bit of the loner was set.

Now, let's have lonerBit store bitSum % 3.

How to shift lonerBit to the i
th
  position?
To compute, we right-shifted (>>) the integer by i bits. So, to shift it back to the i
th
  position, we left-shift (<<) it by i bits.

And which operator can we use to place the i
th
  bit of the loner?
We can use the bitwise OR (|) operator. The 0∣x=x property of bitwise OR will help here.

In code,

loner = loner | (lonerBit << shift)
Readers can implement this solution in their preferred language.

Algorithm
Initialize loner to 0

Using a for loop, iterate over all bits from 0 to 31 using the variable shift.

Initialize bitSum to 0

Using a for loop, iterate over all num in nums

Compute bit as the shift
th
  bit of num using bit = (num >> shift) & 1.

Add bit to bitSum.

Compute lonerBit as bitSum % 3.

Place the shift
th
  bit of loner as loner = loner | (lonerBit << shift).

Return loner.
 */
public class Soln_Bitwise_137_Single_Number_II {

    public static void main(String[] args) {

      int[] nums = {2,2,3,2};
     System.out.println(singleNumber1(nums));
    }

    // this is the best solution
    public static int singleNumber1(int[] nums) {


        int loner =0;
        for(int shift =0; shift<32; shift++ ){

            int bitsum =0;

            for(int num: nums){
                bitsum+= (num>>shift)&1;
            }
            int lonerBit = bitsum%3;
            loner = loner | (lonerBit << shift);
        }
        return loner;
    }

    public int singleNumber(int[] nums) {


        long numSum =0;
        Set<Long> numset = new HashSet<>();

        for(int num:nums){
            numSum+= num;
            numset.add((long)num);

        }

        long sumset =0;

        for(long num:numset){
            sumset+=num;
        }

        return (int)(3*sumset - numSum)/2;

    }
}
