package com.suri.leetcode.medium;

/*
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not

Example 1:

Input:
N = 3, M = 3
mat[][] = 3 30 38
         44 52 54
         57 60 69
X = 62
Output:
0
Explanation:
62 is not present in the
matrix, so output is 0

Example 2:

Input:
N = 1, M = 6
mat[][] = 18 21 27 38 55 67
X = 55
Output:
1
Explanation:
55 is present in the
matrix at 5th cell.

https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Soln_74_Search_In_2DSortedMatrix {

    public static void main(String[] args) {

        int mat[][] = {{3, 30, 38},
                {44, 52, 54},
                {57, 60, 69}};

        System.out.println(searchMatrix(mat, 60));
        System.out.println(searchMatrix(mat, 62));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
