package com.suri.companyWise.amazom;

import java.util.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
  public static void main(String[] args) {

    String strs[]={"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> groupAnagram = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();

    for (String current : strs) {

      char[] characters = current.toCharArray();

      Arrays.sort(characters);

      String key = new String(characters);

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());

      }
      map.get(key).add(current);

    }
    groupAnagram.addAll(map.values());

    return groupAnagram;
  }
}