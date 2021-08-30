package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/02/19
 * @Description: (Overwrite)
 * Min Cost Path | DP-6
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 * You may assume that all costs are positive integers.
 * @History:
 */
public class MinimumCostPath {

    public static void main(String[] args) {

        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println(minCost(cost, 2, 2));

    }

    public static int minCost(int mat[][], int M, int N) {

        int tc[][] = new int[M + 1][N + 1];

           tc[0][0] = mat[0][0];

        for (int i = 1; i <= M; i++) {
            tc[i][0] = tc[i - 1][0] + mat[i][0];
        }

        for (int j = 1; j <= N; j++) {
            tc[0][j] = tc[0][j - 1] + mat[0][j];
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {

                tc[i][j] = Math.min(tc[i - 1][j - 1], Math.min(tc[i - 1][j], tc[i][j - 1])) + mat[i][j];

            }
        }

        return tc[M][N];
    }

}