package com.suri.leetcode.medium;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 * <p>
 * Input: matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 */
public class Soln_1277_CountSquareSubmatrices1 {
  public static void main(String[] args) {

    int arr[][] =
            {{0, 1, 1, 1},
                    {1, 1, 1, 1},
                    {0, 1, 1, 1}
            };
    System.out.println(countSquares(arr));

  }

  public static int countSquares(int[][] matrix) {

    int M = matrix.length;
    int N = matrix[0].length;

    int dp[][] = new int[M + 1][N + 1];

    for (int i = 0; i <= M; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i <= N; i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i <= M; i++) {
      for (int j = 1; j <= N; j++) {

        if (matrix[i - 1][j - 1] == 1) {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }
      }
    }
    int sum = 0;
    for (int i = 0; i <= M; i++) {
      for (int j = 0; j <= N; j++) {
        sum += dp[i][j];
      }
    }
    return sum;
  }
}