package com.suri.leetcode.easy;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
https://leetcode.com/problems/ransom-note
 */

public class Soln_383_Ransom_Note {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i=0;i<ransomNote.length();i++){
            count1[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            count2[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count1[i]>0){
                if(count2[i]<count1[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
