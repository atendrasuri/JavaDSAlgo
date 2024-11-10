package com.suri.leetcode.easy;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.

https://leetcode.com/problems/is-subsequence/description/

https://www.youtube.com/watch?v=UsPWwTY0xr4&t=961s
https://gist.github.com/naresh1406/9d52ef665e9296af639dc1e831a67b55


 */

public class Soln_392_Is_Subsequence {

    public static void main(String[] args) {

        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()){
            return true;
        }
        int i=0;
        for(char ch:t.toCharArray()){
            if(s.charAt(i)== ch){
                i++;
            }
            if(i==s.length()){
                return true;
            }
        }
        return false;

    }
}
