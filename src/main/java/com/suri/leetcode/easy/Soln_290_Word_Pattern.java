package com.suri.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false

https://leetcode.com/problems/word-pattern
 */
public class Soln_290_Word_Pattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));

    }
    public static boolean wordPattern(String pattern, String s) {

        Map<Character, String> map_char = new HashMap<>();

        Map<String, Character> map_word = new HashMap<>();

        String [] words = s.split(" ");

        if(words.length!=pattern.length()){
            return false;
        }

        for(int i=0;i<words.length; i++){

            char c = pattern.charAt(i);
            String w = words[i];

            if(!map_char.containsKey(c)){

                if(map_word.containsKey(w)){
                    return false;
                }else{
                    map_char.put(c, w);
                    map_word.put(w, c);
                }
            }else{

                String mapped_word = map_char.get(c);
                if(!mapped_word.equals(w)){
                    return false;
                }
            }
        }
        return true;

    }
}
