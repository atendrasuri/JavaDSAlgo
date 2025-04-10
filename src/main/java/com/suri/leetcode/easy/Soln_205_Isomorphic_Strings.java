package com.suri.leetcode.easy;
/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true
https://leetcode.com/problems/isomorphic-strings
 */

public class Soln_205_Isomorphic_Strings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }
    public static boolean isIsomorphic(String s, String t) {

        if(s.length()!= t.length()){
            return false;
        }

        int[] counts = new int[256];
        int [] countt = new int[256];
        for(int i =0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(counts[c1]==0 && countt[c2]==0){
                counts[c1] = c2;
                countt[c2]= c1;
            }else if (counts[c1] != c2 || countt[c2] != c1){
                return false;
            }
        }

        return true;

    }
}
