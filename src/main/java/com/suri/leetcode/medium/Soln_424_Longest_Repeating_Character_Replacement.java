package com.suri.leetcode.medium;

/*

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
https://leetcode.com/problems/longest-repeating-character-replacement/description/
https://neetcode.io/problems/longest-repeating-substring-with-replacement

 */

import java.util.HashMap;
import java.util.Map;

public class Soln_424_Longest_Repeating_Character_Replacement {

    public static void main(String[] args) {

        System.out.println(characterReplacement("ABAB", 2));

    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res =0;
        int l =0;
        int maxf= 0;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            while((r-l+1)-maxf>k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l= l+1;
            }
            res = Math.max(res, r-l+1);
        }
        return res;

    }
}
