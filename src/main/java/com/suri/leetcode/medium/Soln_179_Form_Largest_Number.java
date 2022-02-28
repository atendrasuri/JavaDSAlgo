package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

https://leetcode.com/problems/largest-number/
https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 */

public class Soln_179_Form_Largest_Number {
    public static void main(String[] args) {
     int nums[] = {948, 954, 99};
        System.out.println(largestNumber(nums));

    }
    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(""+nums[i]);
        }

        list.sort((a, b)->{
            String X1 = a+""+b;
            String X2 = b+""+a;
            return X1.compareTo(X2)>0?-1:1;
        });

        StringBuilder sb = new StringBuilder();

        for(String s:list){
            sb.append(s);
        }

        String s= sb.toString();
        return s.startsWith("00") ? "0" : s;
    }
}
