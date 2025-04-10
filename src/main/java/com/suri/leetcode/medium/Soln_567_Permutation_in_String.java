package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/permutation-in-string/description/
Given two strings s1 and s2, return true if s2 contains a
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */

public class Soln_567_Permutation_in_String {
    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "lecabee";

        System.out.println(checkInclusion(s1, s2));

    }

    public static boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }

        Map<Character, Integer> s1map = new HashMap<>();



        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            s1map.put(ch, s1map.getOrDefault(ch,0)+1);
        }

        int needed = s1map.size();
        for(int i=0;i<s2.length();i++ ){

            Map<Character, Integer> s2map = new HashMap<>();
            int curr=0;
            for(int j=i;j<s2.length();j++){
                char ch = s2.charAt(j);
                s2map.put(ch, s2map.getOrDefault(ch,0)+1);


                if(s1map.getOrDefault(ch, 0)<s2map.get(ch)){
                    break;
                }
                if(s1map.getOrDefault(ch, 0)==s2map.get(ch)){
                    curr++;
                }
                if(curr==needed){
                    return true;
                }
            }

        }

        return false;

    }
}
