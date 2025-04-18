package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.



Example 1:

Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
Example 2:

Input: n = 7, k = 2
Output: 7
Explanation: Factors list is [1, 7], the 2nd factor is 7.
Example 3:

Input: n = 4, k = 4
Output: -1
Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
https://leetcode.com/problems/the-kth-factor-of-n
 */
public class Soln_1492_The_kth_Factor_of_n {
    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));

    }

    public static int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        int x=1;
        while(x<=n){

            if(n%x==0){
                factors.add(x);
            }
            x++;
        }
        if(factors.size()<k){
            return -1;
        }
        return factors.get(k-1);
    }
}
