package com.suri.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
/*

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
https://leetcode.com/problems/happy-number
 */

public class Soln_202_Happy_Number {
    public static void main(String[] args) {
        System.out.println(isHappy(19));

    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n !=1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n==1;

    }

    private static int getNext(int num){
        int totalsum =0;
        while(num>0){

            int r= num%10;
            totalsum+= (r*r);
            num = num/10;
        }
        return totalsum;
    }
}
