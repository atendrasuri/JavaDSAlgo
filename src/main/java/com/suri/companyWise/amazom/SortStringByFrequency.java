package com.suri.companyWise.amazom;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 */
public class SortStringByFrequency {
  public static void main(String[] args) {

    String str[]={"Hello","Ram", "Hello","Ram","Hello"};
    System.out.println(frequencySort(str));

  }

  public static String frequencySort(String s[]) {
    if (s == null || s.length == 0) {
      return "";
    }

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length; i++) {
      map.put(s[i], map.getOrDefault(s[i], 0) + 1);
    }


    PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

    maxHeap.addAll(map.keySet());

    StringBuilder sb = new StringBuilder();

    while (!maxHeap.isEmpty()) {

      String current = maxHeap.remove();

      for (int i = 0; i < map.get(current); i++) {
        sb.append(current);
      }
    }

    return sb.toString();
  }
}