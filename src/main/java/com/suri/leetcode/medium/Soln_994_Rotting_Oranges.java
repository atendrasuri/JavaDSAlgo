package com.suri.leetcode.medium;
/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

https://leetcode.com/problems/rotting-oranges/description/
 */

import com.suri.common.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Soln_994_Rotting_Oranges {
    public static void main(String[] args) {

        int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(grid));

    }

    public static int orangesRotting(int[][] grid) {

        int ROW = grid.length;
        int COL= grid[0].length;
        int freshOranges =0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for(int i=0;i<ROW; i++){
            for(int j=0;j<COL;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i, j));
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }

        queue.add(new Pair(-1, -1));

        int totalMinitues =-1;

        int[][] directions = {{-1,0}, {0,1}, {1,0},{0, -1}};

        while(!queue.isEmpty()){

            Pair<Integer, Integer> pair = queue.remove();

            int row = pair.key;
            int col = pair.value;

            if(row==-1){
                // We finish one round of processing
                totalMinitues++;
                if(!queue.isEmpty()){
                    // to avoid the endless loop
                    queue.add(new Pair(-1, -1));
                }
            }else{
                // this is a rotten orange
                // then it would contaminate its neighbors

                for(int [] direction: directions){

                    int neighborRow= row+direction[0];
                    int neighborCol = col+direction[1];

                    if(neighborRow>=0 && neighborRow<ROW && neighborCol>=0 && neighborCol<COL){

                        if(grid[neighborRow][neighborCol]==1){
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] =2;
                            freshOranges--;
                            queue.add(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }
        return freshOranges==0?totalMinitues:-1;
    }
}
