package com.suri.leetcode.medium;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

https://leetcode.com/problems/number-of-islands/
 */
public class Soln_200_Number_of_Islands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result += doDfs(grid, i, j, m, n);
                }
            }
        }
        return result;
    }

    public static int doDfs(char[][] grid, int i, int j, int m, int n) {

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        doDfs(grid, i, j + 1, m, n);
        doDfs(grid, i + 1, j, m, n);
        doDfs(grid, i, j - 1, m, n);
        doDfs(grid, i - 1, j, m, n);
        return 1;
    }
}
