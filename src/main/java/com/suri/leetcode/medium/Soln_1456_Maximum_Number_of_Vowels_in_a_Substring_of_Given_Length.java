package com.suri.leetcode.medium;
/*

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

 */

import java.util.Set;

public class Soln_1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int result = Integer.MIN_VALUE;
        int count =0;
        for(int i=0;i<k;i++){
            count+= vowels.contains(s.charAt(i))?1:0;
        }
        result = count;


        for(int i=k;i<s.length(); i++){
            count+= vowels.contains(s.charAt(i))?1:0;
            count-= vowels.contains(s.charAt(i-k))?1:0;
            result = Math.max(result, count);
        }

        return result;


    }
}
