package com.suri.companyWise.amazom;

import java.util.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {
  public static void main(String[] args) {

    String[] words= {"i", "love", "leetcode", "i", "love", "coding"};
    System.out.println(topKFrequent(words,2));
  }

  public static List<String> topKFrequent(String[] words, int k) {


    ArrayList<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : b.getValue() - a.getValue()
    );

    priorityQueue.addAll(map.entrySet());

    while (!priorityQueue.isEmpty() && result.size() < k) {
      result.add(priorityQueue.poll().getKey());
    }
    Collections.sort(result);
    return result;
  }
}