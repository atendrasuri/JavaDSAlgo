package com.suri.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

A substring is a contiguous (non-empty) sequence of characters within a string.

A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.

Given a string word, return the number of vowel substrings in word.



Example 1:

Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"
Example 2:

Input: word = "unicornarihan"
Output: 0
Explanation: Not all 5 vowels are present, so there are no vowel substrings.
Example 3:

Input: word = "cuaieuouac"
Output: 7
Explanation: The vowel substrings of word are as follows (underlined):
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
https://leetcode.com/problems/count-vowel-substrings-of-a-string/

 */
public class Soln_2062_Count_Vowel_Substrings_of_a_String {

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("cuaieuouac")==7);
    }

    public static int countVowelSubstrings(String word) {


        int n = word.length();
        int count=0;


        for(int i=0;i<n; i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<n; j++){
                char ch = word.charAt(j);
                if(!isVowel(ch)){
                    break;
                }
                set.add(ch);
                if(set.size()==5){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
