package com.suri.leetcode.medium;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: 5
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 */

public class Sol_96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(3));

    }

    public static int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
