package com.suri.leetcode.medium;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
https://leetcode.com/problems/decode-string/description
 */

import java.util.Stack;

public class Soln_394_Decode_String {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));

    }
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder currentstr = new StringBuilder();
        int number =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10 +(c-'0');
            }else if(c=='['){
                stack.push(String.valueOf(number));
                stack.push(currentstr.toString());
                number =0;
                currentstr = new StringBuilder();
            }else if(c==']'){
                String previousString = stack.pop();
                int repeatNumber = Integer.parseInt(stack.pop());
                StringBuilder repeatedString = new StringBuilder();
                for(int j=0;j<repeatNumber;j++){
                    repeatedString.append(currentstr);
                }
                // Append the previous string to the repeated string
                currentstr = new StringBuilder(previousString).append(repeatedString);
            }else{
                currentstr.append(c);
            }
        }
        return currentstr.toString();

    }
}
