package com.suri.leetcode.medium;

/**
 *
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 * Example 3:
 *
 * Input: c = 4
 * Output: true
 * Example 4:
 *
 * Input: c = 2
 * Output: true
 * Example 5:
 *
 * Input: c = 1
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= c <= 231 - 1
 */
public class Soln_633_SumofSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(2147483600));

    }
    public static boolean judgeSquareSum(int c) {
        if(c==0){
            return true;
        }

        long l =0;
        long r = (long) Math.sqrt(c);
        while(l<=r){
            long res = ((l*l) + (r*r));
            if(res<c){
                l++;
            }else if(res>c){
                r--;
            }
            else{
                return true;
            }
        }

        return false;

    }
}
