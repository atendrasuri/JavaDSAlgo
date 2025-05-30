package com.suri.companyWise.amazom;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWord {
  public static void main(String[] args) {
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};
    System.out.println(mostCommonWord(paragraph, banned));

  }

  public static String mostCommonWord(String paragraph, String[] banned) {

    HashSet<String> bannedWords = new HashSet<>();

    for (String word : banned) {
      bannedWords.add(word);
    }

    HashMap<String, Integer> counts = new HashMap<>();


    for (String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {

      if (!bannedWords.contains(word)) {
        counts.put(word, counts.getOrDefault(word, 0) + 1);
      }
    }

    String result = "";

    for (String key : counts.keySet()) {
      if (result.equals("") || counts.get(key) > counts.get(result)) {
        result = key;
      }
    }
    return result;
  }
}