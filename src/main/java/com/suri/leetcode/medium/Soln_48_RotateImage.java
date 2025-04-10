package com.suri.leetcode.medium;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
https://leetcode.com/problems/rotate-image/
 */
public class Soln_48_RotateImage {
    public static void main(String[] args) {

        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};

        display(matrix);
        System.out.println();
        rotate(matrix);
        System.out.println();
        display(matrix);


    }
    public static void display(int[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int j=0;j<n;j++){
            for(int i=j;i<n;i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        display(matrix);
        for(int i=0;i<n;i++){
            int li=0;
            int ri= n-1;
            while(li<ri){
                int temp = matrix[i][li];
                matrix[i][li] =  matrix[i][ri];
                matrix[i][ri] = temp;
                li++;
                ri--;
            }
        }
    }

    public void rotate1(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[m][n];


        for(int i=0;i<m;i++){

            for(int j= n-1;j>=0;j--){

                result[j][n-i-1]= matrix[i][j];
            }
        }

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){
                matrix[i][j]= result[i][j];
            }
        }

    }
}
