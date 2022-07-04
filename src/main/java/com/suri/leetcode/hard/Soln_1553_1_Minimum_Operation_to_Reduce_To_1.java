package com.suri.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
TGoogle | Onsite | Min operations to reduce number to 1
Given a positive integer n and 3 operations on n:

n - 1
n / 2 (if n is even)
n / 3 (if n % 3 == 0)
Find the minimum number of above operations to reduce n to 1.

Example 1:

Input: n = 9
Output: 2
Explanation:
Step 1: 9 / 3 = 3
Step 2: 3 / 3 = 1
Example 2:

Input: n = 8
Output: 3
Explanation:
Step 1: 8 / 2 = 4
Step 2: 4 / 2 = 2
Step 3: 2 - 1 = 1
Example 3:

Input: n = 28
Output: 4


https://leetcode.com/discuss/interview-question/538568/google-onsite-min-operations-to-reduce-number-to-1

 */
public class Soln_1553_1_Minimum_Operation_to_Reduce_To_1 {
    public static void main(String[] args) {

        System.out.println(minSteps(9));
        System.out.println(minSteps(8));
        System.out.println(minSteps(28));
    }
    public static int minSteps(int n){
        if(n==1){
            return 0;
        }
        if(n%3==0){
            return 1+ Math.min(minSteps(n / 3), minSteps(n - 1 ));
        }else if(n%2==0){
            return 1+ Math.min(minSteps(n / 2), minSteps(n - 1 ));
        }else{
            return 1+ minSteps(n - 1 );
        }

    }
}
