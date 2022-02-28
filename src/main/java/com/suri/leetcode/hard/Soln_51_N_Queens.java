package com.suri.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Soln_51_N_Queens {
    public static void main(String[] args) {
        //List<List<String>> result =   solveNQueens(8);
        List<List<String>> result =   solveNQueens(4);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solveNQueen(board, 0);
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String> ls = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    ls.add(".");
                }
                if(board[i][j]=='Q'){
                    ls.add("Q");
                }
            }
            result.add(ls);
        }
        return result;
    }

    public static boolean solveNQueen(char [][] board, int col){
        int N = board.length;
        if(col>=N){
            return true;
        }
        for(int i=0;i<N;i++){
            if(isSafe(board, i, col)){
                board[i][col]='Q';
                if(solveNQueen(board, col+1)){
                    return true;
                }else{
                    board[i][col]='.';
                }
            }
        }
        return false;
    }

    public static boolean isSafe(char [][] board, int row, int col){
        int i, j;
        int N = board.length;
        for(i=0;i<col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        for(i=row, j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(i=row, j=col; i<N && j>=0; i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
