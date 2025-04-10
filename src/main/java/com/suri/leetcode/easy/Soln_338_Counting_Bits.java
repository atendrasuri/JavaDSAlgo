package com.suri.leetcode.easy;
/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
https://leetcode.com/problems/counting-bits/description
 */

import java.util.Arrays;

public class Soln_338_Counting_Bits {
    public static void main(String[] args) {

        int[] result1= countBits1(5);

        Arrays.stream(result1).boxed().forEach(System.out::print);
        System.out.println();

        int[] result2= countBits2(5);
        Arrays.stream(result2).boxed().forEach(System.out::print);


    }

    // optimized - time complexity = O(N)

    public static int[] countBits1(int n) {

        int dp[] = new int[n+1];
        dp[0]=0;
        int offset =1;

        for(int i=1;i<=n;i++){

            if(offset*2 ==i){
                offset =i;
            }
            dp[i]= 1+dp[i-offset];
        }
        return dp;

    }

    // Brute force - time complexity = (NlogN)
    public static int[] countBits2(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            int num =i;
            int count = 0;
            while(num>0){
                count+= num%2;
                num = num/2;
            }
            ans[i]= count;
        }
        return ans;

    }
}
