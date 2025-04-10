package com.suri.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

https://leetcode.com/problems/minimum-path-sum/
https://www.youtube.com/watch?v=BzTIOsC0xWM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=7&ab_channel=Pepcoding
https://www.geeksforgeeks.org/min-cost-path-dp-6/

 */
public class Soln_DP_64_Minimum_Path_Sum {
    public static void main(String[] args) {
        int mat[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(mat));

    }
    public static int minPathSum(int[][] mat) {


        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n][m];

        for(int i = n-1;i>=0;i--){

            for(int j=m-1;j>=0;j--){

                if(i==n-1 && j==m-1){
                    dp[i][j] = mat[i][j];
                }else if(i==n-1){

                    dp[i][j] = dp[i][j+1]+mat[i][j];
                }else if(j==m-1){
                    dp[i][j] = dp[i+1][j]+mat[i][j];
                }else{

                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+mat[i][j];
                }
            }
        }
        return dp[0][0];
    }


    public static int minPathSum1(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int dp[][] = new int[M][N];

        dp[0][0]= grid[0][0];

        for(int i=1;i<M;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<N;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<M;i++){
            for(int j =1;j<N;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[M-1][N-1];
    }


}


