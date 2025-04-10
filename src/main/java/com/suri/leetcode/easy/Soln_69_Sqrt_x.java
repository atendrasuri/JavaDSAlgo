package com.suri.leetcode.easy;
/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
https://leetcode.com/problems/sqrtx/description
 */

public class Soln_69_Sqrt_x {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));

    }

    public static int mySqrt(int x) {

        if(x<2){
            return x;
        }
        int l =2;
        int r = x/2;
        long num =0;

        while(l<=r){

            int mid = (l+r)/2;

            num = mid*mid;

            if(num>x){
                r = mid-1;
            }else if(num<x){
                l = mid+1;
            }else{
                return mid;
            }
        }
        return r;

    }
}
