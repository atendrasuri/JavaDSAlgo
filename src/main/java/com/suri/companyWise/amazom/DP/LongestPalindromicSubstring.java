package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * reference:- https://www.youtube.com/watch?v=0xeBqanD5GQ
 */
public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(longestPalindrome("aaaabbaa"));


  }

  public static String longestPalindrome(String s) {

    if (s == null || s.length() < 2) {
      return s;
    }
    int length = s.length();

    boolean isPalindrome[][] = new boolean[length][length];

    int left = 0;
    int right = 0;
    for (int j = 1; j < length; j++)
      for (int i = 0; i < j; i++) {
        boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;

        if (s.charAt(i) == s.charAt(j) && isInnerWordPalindrome) {

          isPalindrome[i][j] = true;

          if (j - i > right - left) {
            left = i;
            right = j;
          }
        }
      }
    System.out.println("========");
      for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
          System.out.print(isPalindrome[i][j]+" ");
        }
        System.out.println();
      }
    return s.substring(left, right + 1);

  }
}