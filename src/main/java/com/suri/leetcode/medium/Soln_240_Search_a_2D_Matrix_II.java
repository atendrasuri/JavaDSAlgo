package com.suri.leetcode.medium;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
https://leetcode.com/problems/search-a-2d-matrix-ii
 */
public class Soln_240_Search_a_2D_Matrix_II {
    public static void main(String[] args) {

    }
    public  static boolean searchMatrix(int[][] matrix, int target) {

        int i =0;
        int j = matrix[0].length-1;
        int n = matrix.length;



        while(i<n && j>=0){
            if(matrix[i][j]== target){
                return true;
            }
            if(target >matrix[i][j]){
                i++;
            }else if(target <matrix[i][j]){
                j--;
            }
        }
        return false;




    }
}
