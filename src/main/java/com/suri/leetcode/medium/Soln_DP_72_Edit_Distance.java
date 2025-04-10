package com.suri.leetcode.medium;

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
https://leetcode.com/problems/edit-distance/description/
https://neetcode.io/problems/edit-distance
https://www.youtube.com/watch?v=tooMn-xfYCU&ab_channel=Pepcoding
 */

public class Soln_DP_72_Edit_Distance {
    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));

    }

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){

            for(int j=0;j<=n;j++){

                if(i==0){
                    dp[i][j]= j;
                }else if(j==0){
                    dp[i][j]=i;
                }else if(word1.charAt(i-1)== word2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }else {
                    dp[i][j]= 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];

    }
}
