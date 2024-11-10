package com.suri.leetcode.hard;
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1


Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters only.

https://leetcode.com/problems/palindrome-partitioning-ii/
https://www.youtube.com/watch?v=qmTtAbOTqcg
 */

public class Soln_132_Palindrome_PartitioningII {
    public static void main(String[] args) {

        System.out.println(minCut("aab"));

    }

    public static int minCut(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; i < dp.length && j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }


        int strg[] = new int[s.length()];
        strg[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            if (dp[0][i]) {
                strg[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i; j > 0; j--) {
                    if (dp[j][i]) {
                        if (strg[j - 1] < min) {
                            min = strg[j - 1];
                        }
                    }
                }
                strg[i] = min + 1;
            }
        }
        return strg[s.length() - 1];

    }
}
