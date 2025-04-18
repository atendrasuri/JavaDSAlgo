package com.suri.leetcode.hard;
/**
 Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 substring
 .



 Example 1:

 Input: s = "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()".
 Example 2:

 Input: s = ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()".
 Example 3:

 Input: s = ""
 Output: 0
 https://leetcode.com/problems/longest-valid-parentheses

 https://www.youtube.com/watch?v=vURq_xYGr-k&ab_channel=PratikshaBakrola
 */
public class Soln_32_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));

    }

    public static int longestValidParentheses(String s) {

        int left =0;
        int right =0;
        int max =0;
        for(int i=0;i<s.length(); i++){

            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                max= Math.max(max, left*2);
            }else if(right>left){
                left=0;
                right=0;
            }
        }

        left=0; right=0;

        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }


            if(left==right){
                max= Math.max(max, left*2);
            }else if(left>right){
                left=0;
                right=0;
            }

        }
        return max;

    }
}
