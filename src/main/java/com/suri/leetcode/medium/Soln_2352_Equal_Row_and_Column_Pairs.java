package com.suri.leetcode.medium;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).



Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]

https://leetcode.com/problems/equal-row-and-column-pairs
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Soln_2352_Equal_Row_and_Column_Pairs {
    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int count=0;

        for(int[] row: grid){
            String rowString = Arrays.toString(row);
            map.put(rowString, map.getOrDefault(rowString, 0)+1);
        }

        for(int i=0; i<grid.length; i++){
            int[] colArray = new int[grid.length];
            for(int r=0;r<grid.length; r++){
                colArray[r]= grid[r][i];
            }

            count+= map.getOrDefault(Arrays.toString(colArray), 0);
        }
        return count;

    }
}
