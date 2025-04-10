package com.suri.leetcode.easy;

/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"
https://leetcode.com/problems/reverse-vowels-of-a-string
 */

public class Soln_345_Reverse_Vowels_of_a_String {

    public static void main(String[] args) {

        System.out.println(reverseVowels("IceCreAm"));

    }
    public static String reverseVowels(String s) {
        int start =0;
        int end = s.length()-1;
        char [] schar = s.toCharArray();
        while(start<end){
            while(start<s.length() && !isVowel(schar[start])){
                start++;
            }
            while(end>=0 && !isVowel(schar[end])){
                end--;
            }
            if(start<end){
                char temp = schar[start];
                schar[start]= schar[end];
                schar[end]= temp;
                start++;
                end--;
            }
        }

        return new String(schar);
    }

    public static boolean isVowel(char ch){
        return ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
                ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
