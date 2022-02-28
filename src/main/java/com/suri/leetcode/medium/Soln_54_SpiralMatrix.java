package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
https://leetcode.com/problems/spiral-matrix/
 */
public class Soln_54_SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        System.out.println(expectedResult.equals(spiralOrder(matrix)));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int ROW = matrix.length;
        int COL = matrix[0].length;
        int r = 0;
        int c = 0;
        while (r < ROW && c < COL) {
            for (int i = c; i < COL; i++) {
                result.add(matrix[r][i]);
            }
            r++;
            for (int i = r; i < ROW; i++) {
                result.add(matrix[i][COL - 1]);
            }
            COL--;
            if (r < ROW) {
                for (int i = COL - 1; i >= c; i--) {
                    result.add(matrix[ROW - 1][i]);
                }
                ROW--;
            }
            if (c < COL) {
                for (int i = ROW - 1; i >= r; i--) {
                    result.add(matrix[i][c]);
                }
                c++;
            }
        }
        return result;
    }
}
