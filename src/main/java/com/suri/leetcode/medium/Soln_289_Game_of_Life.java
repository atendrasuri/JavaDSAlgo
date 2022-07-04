package com.suri.leetcode.medium;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

https://leetcode.com/problems/game-of-life/


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 */
public class Soln_289_Game_of_Life {
    int board[][] = {{0,1,0},{0,0,1},{0,0,0}};
    public static void main(String[] args) throws InterruptedException {

        Soln_289_Game_of_Life obj = new Soln_289_Game_of_Life();
        obj.gameOfLife(obj.board);
        obj.display(obj.board);
    }

    public  void display(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    System.out.print("-- ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

    }
    public void gameOfLife(int[][] board) {

        final int ROW = board.length;
        final int COL = board[0].length;
        int[][] result = new int[ROW][COL];
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                int numberOfAliveNeighbours = numberOfAliveNeighbours(board,i, j, ROW, COL);
                if(board[i][j]==1){
                    if(numberOfAliveNeighbours==2 || numberOfAliveNeighbours==3){
                        result[i][j] = 1;
                    }else if (numberOfAliveNeighbours<2 || numberOfAliveNeighbours>3){
                        result[i][j] = 0;
                    }
                }else{

                    if(numberOfAliveNeighbours==3) {
                        result[i][j] = 1;
                    }else{
                        result[i][j] = 0;
                    }
                }


            }
        }
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                board[i][j]= result[i][j];
            }}


    }





    public int numberOfAliveNeighbours(int[][] board, int row, int col, int ROW, int COL) {

        int numberOfAliveNeighbours = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i != row || j != col) {
                 if (isAlive(board, i, j, ROW, COL)) {

                        numberOfAliveNeighbours++;
                    }
                }
            }
        }
        return numberOfAliveNeighbours;
    }





    public boolean isAlive(int[][] board, int row, int col, int ROW, int COL) {
        if (row < 0 || col < 0 || row >= ROW || col >= COL || board[row][col] != 1) {
            return false;
        }
        return true;
    }
}
