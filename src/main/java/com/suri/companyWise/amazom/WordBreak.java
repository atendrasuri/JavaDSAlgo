package com.suri.companyWise.amazom;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {
  public static void main(String[] args) {

    String s = "leetcode";

    List<String> wordDict = Arrays.asList("leet", "code");

    System.out.println(wordBreak(s, wordDict));

  }

  public static boolean wordBreak(String s, List<String> wordDict) {

    boolean isWordBreak[] = new boolean[s.length() + 1];

    isWordBreak[0] = true;

    for (int i = 0; i < s.length() + 1; i++) {

      for (int j = 0; j < i; j++) {
        if (!isWordBreak[j]) {
          continue;
        }
        if (wordDict.contains(s.substring(j, i))) {
          isWordBreak[i] = true;
          break;
        }
      }
    }
    return isWordBreak[s.length()];

  }
}