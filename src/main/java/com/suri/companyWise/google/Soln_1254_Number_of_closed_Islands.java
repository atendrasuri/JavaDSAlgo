package com.suri.companyWise.google;

/*


https://leetcode.com/problems/number-of-closed-islands/
https://www.geeksforgeeks.org/find-number-of-closed-islands-in-given-matrix/
 */
public class Soln_1254_Number_of_closed_Islands {
    public static void main(String[] args) {

        int matrix[][] = {{0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}};

        System.out.println(closedIslands(matrix, 5, 8));

    }

    public static int closedIslands(int[][] matrix, int N, int M)
    {
        // boundary DFS
        for(int i=0;i<N; i++){

            for(int j=0;j<M;j++){

                if(i*j==0 || i == N-1 || j == M-1){

                    if(matrix[i][j]==1){
                        dfs(matrix, i, j, N, M);
                    }
                }

            }
        }

        int result =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==1){
                    result+=  dfs(matrix, i, j, N, M);
                }
            }
        }

        return result;
    }






    public static int dfs(int[][] matrix, int i, int j, int N, int M ){

        if(i<0 || j<0 || i>=N || j>=M || matrix[i][j]==0){
            return 0;
        }

        matrix[i][j] = 0;

        dfs(matrix, i+1, j, N, M);
        dfs(matrix, i, j+1, N, M);
        dfs(matrix, i-1, j, N, M);
        dfs(matrix, i, j-1, N, M);

        return 1;
    }
}
