package com.suri.leetcode.medium;

/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
https://leetcode.com/problems/remove-k-digits/description
 */

import java.util.Stack;

public class Soln_402_Remove_K_Digits {
    public static void main(String[] args) {

        System.out.println(removeKdigits("1432219", 3));

    }
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char digit : num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()> digit){
                stack.pop();
                k = k-1;
            }
            stack.push(digit);
        }
        for(int i=0;i<k;i++){
            stack.pop();
        }
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for(char digit:stack){
            if(leadingZero && digit=='0') continue;

            leadingZero = false;
            result.append(digit);
        }
        if(result.length()==0){
            return "0";
        }
        return result.toString();
    }
}
