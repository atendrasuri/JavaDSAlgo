package com.suri.leetcode.medium;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
https://leetcode.com/problems/unique-paths/
 */
public class Soln_DP_62_Unique_Paths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
        System.out.println(uniquePathsRecursive(2,2));

    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathsRecursive(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        return uniquePathsRecursive(m-1,n)+uniquePathsRecursive(m,n-1);
    }
}

/*
Complexity Analysis

Time complexity: O(N×M).

Space complexity: O(N×M).

 */
