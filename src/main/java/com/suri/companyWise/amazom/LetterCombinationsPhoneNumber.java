package com.suri.companyWise.amazom;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsPhoneNumber {
  public static void main(String[] args) {
    System.out.println(letterCombinations("8697"));

  }

  public static List<String> letterCombinations(String digits) {
    LinkedList<String> result = new LinkedList<String>();
    if (digits.length() == 0) {
      return result;
    }
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    result.add("");
    while (result.peek().length() != digits.length()) {
      String remove = result.remove();
      String map = mapping[digits.charAt(remove.length()) - '0'];
      for (char c : map.toCharArray()) {
        result.add(remove + c);
      }
    }
    return result;
  }
}