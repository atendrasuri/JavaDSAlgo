package com.suri.leetcode.medium;
/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

https://leetcode.com/problems/longest-palindromic-substring/

 */
public class Soln_DP_5_LongestPalindromicSubstring {
    public static void main(String[] args) {


        System.out.println(longestPalin("babad").equals("bab"));
    }

    public static String longestPalin(String S){


        boolean dp[][] = new boolean[S.length()][S.length()];
        int left=0;
        int right=0;
        for(int g =0;g<S.length();g++){


            for(int i=0, j=g; i<dp.length && j <dp[0].length; i++, j++){

                if(g==0){
                    dp[i][j]= true;
                }else if(g==1){
                    dp[i][j] = S.charAt(i)==S.charAt(j);
                }else{
                    dp[i][j] = S.charAt(i)==S.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j]){

                    if(j-i > right-left){
                        left=i;
                        right=j;
                    }
                }
            }
        }
        return S.substring(left, right+1);


    }
}
