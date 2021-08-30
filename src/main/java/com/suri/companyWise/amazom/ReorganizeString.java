package com.suri.companyWise.amazom;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 */
public class ReorganizeString {
  public static void main(String[] args) {

    System.out.println(reorganizeString("aab"));
    System.out.println(reorganizeString("aaab"));

  }

  public static String reorganizeString(String S) {

    if (S == null || S.length() == 0) {
      return "";
    }

    /* store char-frequency pair into map */
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (char c : S.toCharArray()) {

      int count = map.getOrDefault(c, 0) + 1;

      if (count > (S.length() + 1) / 2) {
        return "";
      }
      map.put(c, count);
    }

    // push all map entry into priority element, by sorting from high frequency to low frequency

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    maxHeap.addAll(map.entrySet());


    StringBuilder result = new StringBuilder();

    while (!maxHeap.isEmpty()) {
      // store character with highest frequency in first
      Map.Entry<Character, Integer> first = maxHeap.remove();
      // if character in first is different with tail character in current string
      if (result.length() == 0 || first.getKey() != result.charAt(result.length() - 1)) {
        result.append(first.getKey());
        first.setValue(first.getValue() - 1);
        // if current character still have more quota left, push back to queue
        if (first.getValue() > 0) {
          maxHeap.add(first);
        }

        // if character in first is same as tail character in current string
        // we need to try the character with second highest frequency
      } else {
        Map.Entry<Character, Integer> second = maxHeap.remove();
        // corner case: if no more elements in queue, the input string should be invalid
        // because we do not have any other characters that different with current string tail
        if (second == null) {
          return "";
        }

        result.append(second.getKey());
        second.setValue(second.getValue() - 1);
        // if current character still have more quota left, push back to queue
        if (second.getValue() > 0) {
          maxHeap.add(second);
        }
        // DO NOT FORGET to push top frequency entry into queue as well
        maxHeap.add(first);
      }
    }

    return result.toString();
  }
}