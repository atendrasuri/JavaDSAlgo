package com.suri.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's
anagrams
 in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/2738760/java-sliding-window-explained/
 */
public class Soln_438_Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        String p ="abc";
        String s = "cbaebabacd";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()> s.length()){
            return result;
        }
        int parr[] = new int[26];
        int sarr[] = new int[26];

        for(int i=0;i<p.length(); i++){
            parr[p.charAt(i)-'a']++;
            sarr[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(parr,sarr)){
            result.add(0);
        }
        int i= 0;
        int j =p.length();
        while(j<s.length()){
            sarr[s.charAt(i++)-'a']--;
            sarr[s.charAt(j++)-'a']++;
            if(Arrays.equals(parr,sarr)){
                result.add(i);
            }
        }
        return result;
    }
}
