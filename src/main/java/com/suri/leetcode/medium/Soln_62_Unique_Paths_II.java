package com.suri.leetcode.medium;

/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

https://www.interviewbit.com/problems/unique-paths-in-a-grid/
 */
public class Soln_62_Unique_Paths_II {
    public static void main(String[] args) {
        int A[][] = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(A));

    }

    public static int uniquePathsWithObstacles(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int dp[][] = new int[m][n];
        if(A[0][0]!=0){
            return 0;
        }
        for(int i=0;i<m;i++){
            if(A[i][0]==1){
                break;
            }else{
                dp[i][0] = 1;
            }
        }
        for(int i=0;i<n;i++){
            if(A[0][i]==1){
                break;
            }else{
                dp[0][i]=1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(A[i][j]!=1){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }
}
