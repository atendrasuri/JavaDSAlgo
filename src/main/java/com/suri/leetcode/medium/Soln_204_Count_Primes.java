package com.suri.leetcode.medium;
/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
https://leetcode.com/problems/count-primes/description
https://leetcode.com/problems/count-primes/solutions/1157321/count-primes
 */

public class Soln_204_Count_Primes {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));

    }
    public static int countPrimes(int n) {

        if(n==0 || n==1){
            return 0;
        }
        int count =0;
        boolean[] numbers = new boolean[n];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (numbers[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    numbers[j] = true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(numbers[i]==false){
                count++;
            }
        }
        return count;

    }
}
