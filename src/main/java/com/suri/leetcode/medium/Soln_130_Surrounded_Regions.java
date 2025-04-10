package com.suri.leetcode.medium;

import com.suri.common.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.



Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]
https://leetcode.com/problems/surrounded-regions/description/

https://www.youtube.com/watch?v=yyofzfxWeKk&ab_channel=KeertiPurswani

Soln ::
Step 1). We select all the cells that are located on the borders of the board.

Step 2). Start from each of the above selected cell, we then perform the DFS traversal.

If a cell on the border happens to be O, then we know that this cell is alive, together with the other O cells that are connected to this border cell, based on the description of the problem. Two cells are connected, if there exists a path consisting of only O letter that bridges between the two cells.

Based on the above conclusion, the goal of our DFS traversal would be to mark out all those connected O cells that is originated from the border, with any distinguished letter such as E.

Step 3). Once we iterate through all border cells, we would then obtain three types of cells:

The one with the X letter: the cell that we could consider as the wall.

The one with the O letter: the cells that are spared in our DFS traversal, i.e. these cells has no connection to the border, therefore they are captured. We then should replace these cell with X letter.

The one with the E letter: these are the cells that are marked during our DFS traversal, i.e. these are the cells that has at least one connection to the borders, therefore they are not captured. As a result, we would revert the cell to its original letter O.
 */
public class Soln_130_Surrounded_Regions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);


    }

    public static void solve(char[][] board) {

        int ROW = board.length;
        int COL = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<>();
        // step1 - border & coonect 'O' - mark them as 'E'
        for(int r=0;r<ROW; r++){
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, COL-1));
        }

        for(int c=0;c<COL; c++){
            borders.add(new Pair(0, c));
            borders.add(new Pair(ROW-1, c));
        }

        // Step 2). mark the escaped cells
        for(Pair<Integer, Integer> pair: borders){
            doDFS(board, pair.key, pair.value, ROW, COL);
        }


        //step3 - leftover 'O' - flip to X & flip back 'E' to 'O'

        for(int r=0;r<ROW; r++){
            for(int c=0;c<COL;c++){
                if(board[r][c]=='O'){
                    board[r][c] = 'X';
                }
                if(board[r][c]=='E'){
                    board[r][c] = 'O';
                }
            }
        }

    }

    public static void doDFS(char [][] board, int r, int c, int ROW, int COL){
        if( r<0 || r>=ROW || c<0 || c>=COL || board[r][c]!='O'){
            return;
        }
        board[r][c] = 'E';
        doDFS(board, r+1, c, ROW, COL);
        doDFS(board, r, c+1, ROW, COL);
        doDFS(board, r-1, c, ROW, COL);
        doDFS(board, r, c-1, ROW, COL);
    }


}
