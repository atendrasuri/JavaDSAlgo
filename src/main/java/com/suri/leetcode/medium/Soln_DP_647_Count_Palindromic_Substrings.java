package com.suri.leetcode.medium;

/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

https://leetcode.com/problems/palindromic-substrings/

https://www.youtube.com/watch?v=XmSOWnL6T_I
 */
public class Soln_DP_647_Count_Palindromic_Substrings {
    public static void main(String[] args) {

        System.out.println(countPalindromicSubstrings("abc"));

    }

    public int countSubstrings(String s) {


        int count =0;

        for(int i=0;i<s.length(); i++){

            count+= palin(s, i, i);
            count+= palin(s, i, i+1);
        }
        return count;

    }

    public int palin(String s, int left, int right){

        int count =0;
        while(left>=0 && left<s.length() && right>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }

    public static int countPalindromicSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count =0;
        for(int g=0;g<dp.length;g++){
            for(int i=0, j=g;i<dp.length && j<dp[0].length; i++, j++){
                if(g==0){
                    dp[i][j] = true;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]= true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j]){
                    count = count+1;
                }
            }
        }
        return count;

    }
}
