package com.suri.companyWise.google;

public class UniquePathWithObstacle {

    public static void main(String[] args) {

  int A[][] =  {{0, 0},
        {0, 0},
        {0, 0},
        {1, 0},
        {0, 0}};
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
            if(A[i][0]!=1){
                dp[i][0] = 1;
            }
        }

        for(int i=0;i<n;i++){
            if(A[0][i]!=1){
                dp[0][i] = 1;
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


