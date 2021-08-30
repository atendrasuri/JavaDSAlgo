package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
  public static void main(String[] args) {
    int grid[][] = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
    System.out.println(numIslands(grid));

  }

  public static int numIslands(int[][] grid) {

    if (grid == null || grid.length == 0) {
      return 0;
    }
    int totalCount = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          totalCount += doDfs(grid, i, j);
        }
      }
    }
    return totalCount;

  }

  public static int doDfs(int[][] grid, int i, int j) {

    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;

    doDfs(grid, i, j + 1);
    doDfs(grid, i, j - 1);
    doDfs(grid, i + 1, j);
    doDfs(grid, i - 1, j);

    //if diagonal elements are also included
    /*doDfs(grid, i - 1, j-1);
    doDfs(grid, i + 1, j+1);
    doDfs(grid, i + 1, j-1);
    doDfs(grid, i - 1, j+1);*/
    return 1;

  }
}