package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
  public static void main(String[] args) {

    System.out.println(uniquePaths(3, 2));

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

      for (int j = 1; j < dp[i].length; j++) {

        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[m - 1][n - 1];

  }
}