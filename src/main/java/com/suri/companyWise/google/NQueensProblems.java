package com.suri.companyWise.google;

/**
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. Given an integer n, print all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens’ placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].


 Input:
 The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the chessboard.

 Output:
 For each test case, output your solutions on one line where each solution is enclosed in square brackets '[', ']' separated by a space . The solutions are permutations of {1, 2, 3 …, n} in increasing order where the number in the ith place denotes the ith-column queen is placed in the row with that number, if no solution exists print -1.

 Constraints:
 1 <= T <= 10
 1 <= n <= 10

 Example:
 Input
 2
 1
 4
 Output:
 [1 ]
 [2 4 1 3 ] [3 1 4 2 ]
 */
public class NQueensProblems {
  static final int N = 4;

  public static void main(String[] args) {
    int board[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};

    if (solveNQueen(board, 0) == false) {
      System.out.print("Solution does not exist");
      return;
    }

    printSolution(board);
    return;
  }

  static void printSolution(int board[][]) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(" " + board[i][j]
                + " ");
      System.out.println();
    }
  }

  public static boolean solveNQueen(int board[][], int col) {
    if (col >= N) {
      return true;
    }
    for (int i = 0; i < N; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        if (solveNQueen(board, col + 1)) {
          return true;
        } else {
          board[i][col] = 0;
        }
      }
    }
    return false;
  }

  public static boolean isSafe(int board[][], int row, int col) {
    int i, j;
    // check the row on left side
    for (i = 0; i < col; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }
    // . upper diagonalon left side
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    // lower diagonal on left side
    for (i = row, j = col; i < N && j >= 0; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    return true;
  }
}