package com.suri.leetcode.medium;
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
https://leetcode.com/problems/reverse-integer/description
 */

public class Soln_7_Reverse_Integer {
    public static void main(String[] args) {
        System.out.println(reverse(123));

    }
    public static int reverse(int x) {

        int INT_MAX = Integer.MAX_VALUE ;
        int INT_MIN = Integer.MIN_VALUE;


        int reverse =0;

        while(Math.abs(x)>0){

            int r = x%10;
            if (reverse > INT_MAX / 10 || (reverse == INT_MAX / 10 && r > 7)) {
                return 0; // Overflow
            }
            if (reverse < INT_MIN / 10 || (reverse == INT_MIN / 10 && r < -8)) {
                return 0; // Underflow
            }
            reverse = reverse*10+r;
            x = x/10;
        }
        return x<0 ? (-reverse):reverse;
    }
}
