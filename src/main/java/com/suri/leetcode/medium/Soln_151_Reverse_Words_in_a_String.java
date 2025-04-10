package com.suri.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
https://leetcode.com/problems/reverse-words-in-a-string
 */
public class Soln_151_Reverse_Words_in_a_String {
    public static void main(String[] args) {

        String str = "the sky is blue";
        System.out.println(reverseWords1(str));

    }
    public static String reverseWords1(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        for(int i=0; i<words.length/2; i++){
            String temp = words[i];
            words[i]= words[words.length-i-1];
            words[words.length-i-1]= temp;
        }
        return String.join(" ", words);
    }

    public static String reverseWords(String s) {

        s= s.trim();

        List<String> wordList = Arrays.asList(s.split("\\s+"));

        Collections.reverse(wordList);

        return String.join(" ", wordList);
    }
}
