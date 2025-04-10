package com.suri.leetcode.easy;

/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

https://leetcode.com/problems/valid-palindrome-ii

 */

public class Soln_680_Valid_Palindrome_II {
    public static void main(String[] args) {

        System.out.println(validPalindrome("aba"));

    }

    public static boolean validPalindrome(String s) {

        int i=0;
        int j = s.length()-1;


        while(i<j){

            // Found a mismatched pair - try both deletions
            if(s.charAt(i)!=s.charAt(j)){
                return (checkPalindrome(s, i, j-1) || checkPalindrome(s, i+1, j));
            }
            i++;
            j--;
        }
        return true;

    }


    private static boolean checkPalindrome(String s, int i, int j){

        while(i<j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
