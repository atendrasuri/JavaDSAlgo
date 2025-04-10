package com.suri.leetcode.easy;

/*
Given two strings s and t, return true if t is an
anagram
 of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
https://leetcode.com/problems/valid-anagram/

 */
public class Soln_242_Valid_Anagram {
    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));

    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int count[] = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int val:count){

            if(val!=0){
                return false;
            }
        }

        return true;

    }
}
