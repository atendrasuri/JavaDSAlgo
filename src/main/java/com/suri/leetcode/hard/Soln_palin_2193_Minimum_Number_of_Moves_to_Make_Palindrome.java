package com.suri.leetcode.hard;

/*
You are given a string s consisting only of lowercase English letters.

In one move, you can select any two adjacent characters of s and swap them.

Return the minimum number of moves needed to make s a palindrome.

Note that the input will be generated such that s can always be converted to a palindrome.



Example 1:

Input: s = "aabb"
Output: 2
Explanation:
We can obtain two palindromes from s, "abba" and "baab".
- We can obtain "abba" from s in 2 moves: "aabb" -> "abab" -> "abba".
- We can obtain "baab" from s in 2 moves: "aabb" -> "abab" -> "baab".
Thus, the minimum number of moves needed to make s a palindrome is 2.
Example 2:

Input: s = "letelt"
Output: 2
Explanation:
One of the palindromes we can obtain from s in 2 moves is "lettel".
One of the ways we can obtain it is "letelt" -> "letetl" -> "lettel".
Other palindromes such as "tleelt" can also be obtained in 2 moves.
It can be shown that it is not possible to obtain a palindrome in less than 2 moves.
https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/description/
 */

public class Soln_palin_2193_Minimum_Number_of_Moves_to_Make_Palindrome {

    public static void main(String[] args) {

        System.out.println(minMovesToMakePalindrome("aabb"));

    }

    public static int minMovesToMakePalindrome(String s) {

        if(s==null || s.isEmpty()){
            return 0;
        }

        char[] arr = s.toCharArray();

        int l = 0;
        int r = s.length()-1;
        int moves =0;

        while(l<r){

            int left =l;
            int right =r;

            // Find the matching character for arr[l] from the right
            while(arr[left]!= arr[right]){
                right--;
            }
            // If left and right meet, it means this is a unique middle character
            if(left==right){
                // Swap it one step towards the center
                swap(arr, right, right+1);
                moves++;
                continue;
            }


            // Move the matching character rightwards until it reaches the correct position
            for(int i=right; i<r; i++){
                swap(arr, i, i+1);
                moves++;
            }
            l++;
            r--;
        }
        return moves;

    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }

}
