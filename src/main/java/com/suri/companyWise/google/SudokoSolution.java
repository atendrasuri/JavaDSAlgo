package com.suri.companyWise.google;

import java.util.HashSet;
import java.util.Set;

/**
 Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (mat[][]). The task to print a solved Sudoku. For simplicity you may assume that there will be only one unique solution.

 Sample Sudoku for you to get the logic for its solution:



 Input:
 The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

 Output:
 For each test case, in a new line, print the space separated values of the solution of the the sudoku.

 Constraints:
 1 <= T <= 10
 0 <= mat[] <= 9

 Example:
 Input:
 1
 3 0 6 5 0 8 4 0 0
 5 2 0 0 0 0 0 0 0
 0 8 7 0 0 0 0 3 1
 0 0 3 0 1 0 0 8 0
 9 0 0 8 6 3 0 0 5
 0 5 0 0 9 0 6 0 0
 1 3 0 0 0 0 2 5 0
 0 0 0 0 0 0 0 7 4
 0 0 5 2 0 6 3 0 0

 Output:
 3 1 6 5 7 8 4 9 2
 5 2 9 1 3 4 7 6 8
 4 8 7 6 2 9 5 3 1
 2 6 3 4 1 5 9 8 7
 9 7 4 8 6 3 1 2 5
 8 5 1 7 9 2 6 4 3
 1 3 8 9 4 7 2 5 6
 6 9 2 3 5 1 8 7 4
 7 4 5 2 8 6 3 1 9

 Explanation:
 Testcase 1: Not needed, I guess. Sp;ved sudoku is already given in output.
 */
public class SudokoSolution {
  static int backTrack =0;
  public static void main(String[] args) {

    Set<String> s = new HashSet<>();
    System.out.println(s.add(1+"0"));
    System.out.println(s.add(1+"0"));
    System.out.println(s.add(1+"0"));
    System.out.println(s.add(1+"0"));


    int[][] board = new int[][]
            {
                    {3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}
            };
    int N = board.length;

    if (solveSuduko(board, N)) {
      print(board, N); // print solution
    } else {
      System.out.println("No solution");
    }

  }

  public static void print(int[][] board, int N) {
    // we got the answer, just print it
    for (int r = 0; r < N; r++) {
      for (int d = 0; d < N; d++) {
        System.out.print(board[r][d]);
        System.out.print(" ");
      }
      System.out.print("\n");

      if ((r + 1) % (int) Math.sqrt(N) == 0) {
        System.out.print("");
      }
    }
  }


  public static boolean isSafe(int board[][], int row, int col, int num) {

    for (int r = 0; r < board.length; r++) {
      if (board[row][r] == num) {
        return false;
      }
    }

    for (int c = 0; c < board.length; c++) {
      if (board[c][col] == num) {
        return false;
      }
    }

    int sqrt = (int)Math.sqrt(board.length);

    int boxRowStart = row - row % sqrt;
    int boxColStart = col - col % sqrt;

    for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
      for (int j = boxColStart; j < boxColStart + sqrt; j++) {
        if (board[i][j] == num) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean solveSuduko(int board[][], int n) {

    int row = -1;
    int col = -1;
    boolean isEmpty = true;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 0) {
          row = i;
          col = j;
          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }

    if (isEmpty) {
      return true;
    }
    System.out.println("********");
    print(board,9);
    for (int num = 1; num <= n; num++) {

      if (isSafe(board, row, col, num)) {
        board[row][col] = num;

        if (solveSuduko(board, n)) {
          return true;
        } else {
          backTrack++;
          board[row][col] = 0;
          System.out.println(backTrack);
        }
      }
    }
    return false;
  }
}
