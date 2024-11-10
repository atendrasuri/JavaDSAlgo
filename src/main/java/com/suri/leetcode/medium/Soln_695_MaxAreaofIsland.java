package com.suri.leetcode.medium;

/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.


Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

https://leetcode.com/problems/max-area-of-island/
https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1
 */
public class Soln_695_MaxAreaofIsland {
    public static void main(String[] args) {

       // int grid[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
       int grid[][] = {{0,1}};
        System.out.println(findMaxArea(grid));
    }

    public static int findMaxArea(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    result = Math.max(result, doDfs(grid, i,j));
                }
            }
        }
        return result;
    }

    public static int doDfs(int[][] grid, int i, int j ){

        if(i<0 || i>=grid.length|| j<0 || j>=grid[i].length || grid[i][j]==0){

            return 0;
        }
        grid[i][j]=0;
        int count=1;
        count+= doDfs(grid, i, j+1);
        count+= doDfs(grid, i+1, j+1);
        count+= doDfs(grid, i+1, j);
        count+= doDfs(grid, i+1, j-1);
        count+= doDfs(grid, i, j-1);
        count+= doDfs(grid, i-1, j-1);
        count+= doDfs(grid, i-1, j);
        count+= doDfs(grid, i-1, j+1);
        return count;
    }

    public int doDfsWithouDigonal(int [][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }
        int count =1;
        grid[i][j] =0;
        count+=doDfsWithouDigonal(grid, i, j+1);
        count+=doDfsWithouDigonal(grid, i+1, j);
        count+=doDfsWithouDigonal(grid, i, j-1);
        count+=doDfsWithouDigonal(grid, i-1, j);
        return count;

    }
}
