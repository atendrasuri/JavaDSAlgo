package com.suri.leetcode.medium;

/*
Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down and 4 diagonal directions.

Example 1:

Input: grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: {{0,0}}
Expalnation: From (0,0) one can find "abc"
in horizontally right direction.

Example 2:

Input: grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
,word = "abe"
Output: {{0,0},{0,2},{1,0}}
Explanation: From (0,0) one can find "abe" in
right-down diagonal. From (0,2) one can
find "abe" in left-down diagonal. From
(1,0) one can find "abe" in Horizontally right
direction.

https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
https://leetcode.com/problems/word-search/
 */
public class Soln_79_WordSearchInGrid {
    public static void main(String[] args) {

        char grid[][] ={{'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}};

        int[][] result = searchWord(grid, "GEEKS");

        for(int i=0;i< result.length;i++){
            System.out.println(result[i][0]+"  "+result[i][1]);
        }

        char board[][] = {{'C','A','A'},
                           {'A','A','A'},
                            {'B','C','D'}};

        System.out.println(exist(board, "AAB"));
    }

    public static int[][] searchWord(char[][] grid, String word)
    {
        int result[][] = new int[grid.length][2];

        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==word.charAt(0)){

                    if(dfs(grid, i, j, 0, word)){
                        result[cnt][0]= i;
                        result[cnt][1]= j;
                        cnt++;
                    }
                }
            }

        }
        return result;
    }

    public static boolean dfs(char[][] grid, int i, int j, int count, String word){
       if(word.length()==count){
           return true;
       }
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]!= word.charAt(count)){
            return false;
        }
        grid[i][j]='0';
        return dfs(grid, i, j+1, count+1, word) ||
                dfs(grid, i, j-1, count+1, word) ||
                dfs(grid, i+1, j, count+1, word) ||
                dfs(grid, i-1, j, count+1, word) ||
                dfs(grid, i-1, j-1, count+1, word) ||
                dfs(grid, i+1, j+1, count+1, word) ||
                dfs(grid, i+1, j-1, count+1, word) ||
                dfs(grid, i-1, j+1, count+1, word) ;

    }


    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length; i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]== word.charAt(0)){
                    if(doDfs(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static boolean doDfs(char[][] board, int i, int j, int count, String word){
        if(word.length()==count){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j]!=word.charAt(count) ){
            return false;
        }

        char temp = board[i][j];
        board[i][j]='0';

        boolean found = doDfs(board, i, j+1, count+1, word) ||
                doDfs(board, i, j-1, count+1, word)||
                doDfs(board, i+1, j, count+1, word)||
                doDfs(board, i-1, j, count+1, word);
        board[i][j]= temp;
        return found;
    }
}
