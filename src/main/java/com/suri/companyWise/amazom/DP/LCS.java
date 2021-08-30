package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/02/19
 * @Description: (Overwrite)
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * <p>
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * @History:
 */
public class LCS {

    public static void main(String[] args) {

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(" LCS is :-" + findLCS(str1, str2));
        System.out.println(" LCS is :- using recursion "+findLCSRecusrsion(str1,str2,0,0));

    }

// using dynamic programming
    public static int findLCS(String str1, String str2) {

        int M = str1.length();
        int N = str2.length();

        int dp[][] = new int[M + 1][N + 1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[M][N];

    }
    // using recursion
    public static int findLCSRecusrsion(String str1, String str2, int i, int j) {
        if(i>= str1.length() || j>=str2.length()){
            return 0;
        }
        if(str1.charAt(i)==str2.charAt(j)){
            return 1+findLCSRecusrsion(str1,str2,i+1,j+1);
        }
        else{
            return Math.max(findLCSRecusrsion(str1,str2,i+1,j),findLCSRecusrsion(str1,str2,i,j+1));
        }

    }
}