package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
  public static void main(String[] args) {

    String str[] = {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(str));

  }

  public static String longestCommonPrefix(String[] strs) {
    String longestCommonPrefix = "";
    if (strs.length == 0 || strs == null) {
      return longestCommonPrefix;
    }

    int index = 0;
    for (char c : strs[0].toCharArray()) {

      for (int i = 1; i < strs.length; i++) {
        if (index >= strs[i].length() || strs[i].charAt(index) != c) {
          return longestCommonPrefix;
        }

      }
      longestCommonPrefix += c;
      index++;
    }
    return longestCommonPrefix;
  }
}