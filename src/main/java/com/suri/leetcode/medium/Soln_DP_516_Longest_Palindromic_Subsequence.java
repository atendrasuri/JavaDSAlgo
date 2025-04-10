package com.suri.leetcode.medium;
/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".


Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.

https://leetcode.com/problems/longest-palindromic-subsequence/
https://www.youtube.com/watch?v=RiNzHfoA2Lo

 */
public class Soln_DP_516_Longest_Palindromic_Subsequence {
    public static void main(String[] args) {


        System.out.println(longestPalinSubseq("bbbab")==4);
        System.out.println(longestPalindromeSubseqBestWay("bbbab")==4);
    }

    // https://www.youtube.com/watch?v=6i_T5kkfv4A&ab_channel=takeUforward
    // approach - just reverse the string and find out the LCS
    public static int longestPalindromeSubseqBestWay(String s) {
        String text1 = s;
        String text2 = reverseString(s);
        int n = text1.length();
        int[][]dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else {
                    if(text1.charAt(i-1)== text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][n];
    }
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }




    public static int longestPalinSubseq(String S)
    {
        //code here

        int dp[][] = new int[S.length()][S.length()];


        for(int g =0;g<dp.length;g++){


            for(int i =0,j=g;i<dp.length && j<dp[0].length;i++,j++){

                if(g==0){
                    dp[i][j] = 1;
                }else if(g==1){

                    dp[i][j] = S.charAt(i)==S.charAt(j)?2:1;

                }else{

                    if(S.charAt(i)==S.charAt(j)){

                        dp[i][j] = 2+dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }


                }


            }

        }
        return dp[0][S.length()-1];

    }
}
