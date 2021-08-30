package com.suri.companyWise.google;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        int[][] validboard = new int[][]
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

        System.out.println(isValidSudoku(validboard));

        int[][] invalidboard = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 3, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        System.out.println(isValidSudoku(invalidboard));
    }
    public static boolean isValidSudoku(int[][] board) {

        Set<String> seen = new HashSet<>();

        for(int i=0;i<board.length; i++){
            for(int j=0;j<board.length; j++){
                if(board[i][j]!=0){
                    int currentVal = board[i][j];
                    if((!seen.add(currentVal+"row"+i))
                            || (!seen.add(currentVal+"col"+j))
                            || (!seen.add(currentVal+"box"+i/3+""+j/3))){
                        return false;
                    }

                }
            }
        }
        return true;

    }
}
