package com.suri.leetcode.medium;

/*
Given a binary matrix mat of size n * m, find out the maximum size square sub-matrix with all 1s.

Input: n = 2, m = 2
mat = {{1, 1},
       {1, 1}}
Output: 2
Explaination: The maximum size of the square
sub-matrix is 2. The matrix itself is the
maximum sized sub-matrix in this case.


Input: n = 2, m = 2
mat = {{0, 0},
       {0, 0}}
Output: 0
Explaination: There is no 1 in the matrix.



https://leetcode.com/problems/maximal-square/
https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
https://www.youtube.com/watch?v=UagRoA3C5VQ&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&ab_channel=Pepcoding

 */
public class Soln_DP_221_LargestSquareSubMatrix1s {
    public static void main(String[] args) {

        int mat[][] = {{1, 0, 1, 0 ,0},{1, 0, 1, 1,1},{1, 1, 1, 1, 1},{1, 0, 0, 1, 0}};
        System.out.println(maxSquare(mat.length, mat[0].length, mat));

    }

    static int maxSquare(int n, int m, int mat[][]) {
        // code here

        int dp[][] = new int[n][m];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = mat[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = mat[i][j];
                } else if (j == m - 1) {
                    dp[i][j] = mat[i][j];
                } else {
                    if (mat[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                    }
                }

                if (dp[i][j] > ans) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }
}
