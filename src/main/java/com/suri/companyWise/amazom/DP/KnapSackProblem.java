package com.suri.companyWise.amazom.DP;

/**
 0-1 Knapsack Problem | DP-10
 Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

 knapsack-problem
 */
public class KnapSackProblem {

  public static void main(String[] args) {
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
    //code
  }

  public static int knapSack(int W, int wt[], int val[], int n) {

    int i, j = 0;

    int T[][] = new int[n + 1][W + 1];

    for (i = 0; i <= n; i++) {
      for (j = 0; j <= W; j++) {
        if (i == 0 || j == 0) {
          T[i][j] = 0;
        } else if (wt[i - 1] <= j) {

          T[i][j] = Math.max((val[i - 1] + T[i - 1][j - wt[i - 1]]), T[i - 1][j]);
        } else {
          T[i][j] = T[i - 1][j];
        }
      }
    }
    return T[n][W];

  }
}
