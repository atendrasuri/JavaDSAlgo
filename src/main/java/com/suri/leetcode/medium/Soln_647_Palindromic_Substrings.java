package com.suri.leetcode.medium;

/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
https://leetcode.com/problems/palindromic-substrings/description
 */

public class Soln_647_Palindromic_Substrings {

    public static void main(String[] args) {

        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            result+= isPalin(i,i,s);
            result+= isPalin(i,i+1,s);
        }
        return result;
    }



    public static int isPalin(int left, int right, String s){
        int count =0;
        while(left>=0 && left<s.length() && right>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left = left-1;
            right = right+1;
            count = count+1;
        }
        return count;
    }
}
