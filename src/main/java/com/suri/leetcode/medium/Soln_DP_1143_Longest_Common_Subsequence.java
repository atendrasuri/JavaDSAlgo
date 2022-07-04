package com.suri.leetcode.medium;

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

https://leetcode.com/problems/longest-common-subsequence/
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

 */
public class Soln_DP_1143_Longest_Common_Subsequence {
    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abcde","ace"));

        System.out.println(longestCommonSubsequence("abcde","ace", 5, 3));
    }

    public static int longestCommonSubsequence(String text1, String text2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return 1 + longestCommonSubsequence(text1, text2, m - 1, n - 1);
        } else
            return Math.max(longestCommonSubsequence(text1, text2, m - 1, n), longestCommonSubsequence(text1, text2, m, n - 1));
    }



    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }

}
