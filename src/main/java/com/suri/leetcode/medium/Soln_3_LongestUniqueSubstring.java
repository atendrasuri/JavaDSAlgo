package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string s, find the length of the longest
 substring
 without repeating characters.
 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 https://leetcode.com/problems/longest-substring-without-repeating-characters/
 https://www.youtube.com/watch?v=9Kc0eZBGL1U&ab_channel=Pepcoding

 [ COMPANY TAGS] = Amazon, Google, Microsoft, Oracle
 */
public class Soln_3_LongestUniqueSubstring {
  public static void main(String[] args) {

    System.out.println(lengthOfLongestSubstringLatest("abcabcbb"));

    System.out.println(lengthOfLongestSubstring("abcabcbb"));

    System.out.println(lengthOfLongestSubstring2("abcabcbb"));

  }

  public static int lengthOfLongestSubstringLatest(String s) {

    if(s== null || s.length()==0){
      return 0;
    }


    Map<Character, Integer> map = new HashMap<>();

    int len =0;
    int maxLen =0;

    int startIndex =0;
    int endIndex =0;

    while(endIndex<s.length()){

      if(map.containsKey(s.charAt(endIndex)) && map.get(s.charAt(endIndex))>=startIndex){

        startIndex = map.get(s.charAt(endIndex))+1;
      }else{

        len = endIndex-startIndex+1;

        maxLen = Math.max(len, maxLen);
      }

      map.put(s.charAt(endIndex), endIndex);
      endIndex++;

    }
    return maxLen;

  }

  public static int lengthOfLongestSubstring(String s) {


    if (s.length() == 0) {
      return 0;
    }
    char[] str = s.toCharArray();

    int maxLen = 0;
    int currLen = 0;
    int startIndex = 0;
    int endIndex = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (endIndex < str.length) {

      if (map.get(str[endIndex]) != null && map.get(str[endIndex]) >= startIndex) {

        startIndex = map.get(str[endIndex]) + 1;
      } else {
        currLen = endIndex - startIndex + 1;


        if (currLen > maxLen) {

          maxLen = currLen;
        }
      }
      map.put(str[endIndex], endIndex);
      endIndex = endIndex + 1;
    }
    return maxLen;
  }

  public int lengthOfLongestSubstring1(String s) {
    int startIndex = 0;
    int endIndex = 0;
    int current_len = 0;
    int maxLen = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (endIndex < s.length()) {
      //if current character already present in map
      if (map.get(s.charAt(endIndex)) != null && startIndex <= map.get(s.charAt(endIndex))) {
        startIndex = map.get(s.charAt(endIndex)) + 1;
      } else {
        current_len = endIndex - startIndex + 1;
        if (current_len > maxLen) {
          maxLen = current_len;
        }
      }
      map.put(s.charAt(endIndex), endIndex);
      endIndex = endIndex + 1;
    }
    return maxLen;
  }

  //third approach
  public static int lengthOfLongestSubstring2(String str) {
    int result = 0;
    int i = -1;
    int j = -1;
    Map<Character, Integer> map = new HashMap<>();
    while (true) {
      boolean f1 = false;
      boolean f2 = false;
      //acquire
      while (i < str.length() - 1) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.get(ch) == 2) {
          break;
        } else {
          int len = i - j;
          if (len > result) {
            result = len;
          }
        }
      }
      //release
      while (j < i) {
        f2 = true;
        j++;
        char ch = str.charAt(j);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 1) {
          break;
        }
      }
      if (f1 == false && f2 == false) {
        break;
      }
    }
    return result;
  }
}