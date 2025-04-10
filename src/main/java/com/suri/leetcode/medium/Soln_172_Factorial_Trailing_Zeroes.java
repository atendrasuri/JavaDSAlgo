package com.suri.leetcode.medium;

/*
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.



Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0

https://leetcode.com/problems/factorial-trailing-zeroes

Understanding the Problem
The trailing zeroes in a factorial come from factors of
10
10. Each
10
10 is the result of multiplying
2
2 and
5
5.

In
𝑛
!
n! (factorial of
𝑛
n), there are usually more factors of
2
2 than factors of
5
5. So, the number of trailing zeroes is determined by the number of
5
5's in the factorization of
𝑛
!
n!.

Steps to Solve
Count the number of multiples of
5
5 in
𝑛
n.
Count the number of multiples of
25
25 (as each contributes an extra
5
5).
Count the number of multiples of
125
125, and so on...
Add up all these counts.

https://leetcode.com/problems/factorial-trailing-zeroes/solutions/545913/factorial-trailing-zeroes/?envType=study-plan-v2&envId=top-interview-150
 */
public class Soln_172_Factorial_Trailing_Zeroes {
    public static void main(String[] args) {

        System.out.println(trailingZeroes(10));

    }

    public static int trailingZeroes(int n) {

        int count =0;
        int divisor =5;

        while(divisor<=n){

            count+= n/divisor;
            divisor = divisor*5;
        }
        return count;

    }
}
