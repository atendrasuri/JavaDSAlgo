package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/02/19
 * @Description: (Overwrite)
 *
 * Given a matrix of N * M.
 * Find the maximum path sum in matrix.
 * The maximum path is sum of all elements from first row to last row where you are allowed to move only down or diagonally to left or right.
 * You can start from any element in first row.
 * @History:
 */
public class MaxPathSumMatrix {

    public static int M = 4, N = 6;

    public static void main(String[] args) {

        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };

        System.out.println(" Maximum path sum in matrix is:-  "+findMaxPathSum(mat));

    }

    public static int findMaxPathSum(int mat[][]) {


        // To find max val in first row
        int res = -1;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, mat[0][i]);
        }

        for (int i = 1; i < M; i++) {
            res = -1;

            for (int j = 0; j < N; j++) {

                // When all three  paths are possible
                if (j > 0 && j < N - 1) {
                    mat[i][j] += Math.max(mat[i - 1][j], Math.max(mat[i - 1][j - 1], mat[i - 1][j + 1]));
                }
                // When diagonal right is not possible
                else if (j > 0) {
                    mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j - 1]);
                }
                // When diagonal left is not possible
                else if (j < N - 1) {
                    mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j + 1]);

                }

                res = Math.max(mat[i][j], res);
            }
        }


        return res;


    }
}