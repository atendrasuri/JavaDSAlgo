package com.suri.companyWise.amazom;


import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAllAdjacentDuplicatesInString {
  public static void main(String[] args) {


    System.out.println(removeDuplicates("abbaca"));

  }

  public static String removeDuplicates(String str) {
    if (str.length() == 0) {
      return new String();
    }

    Stack<Character> stack = new Stack<>();

    int n = str.length();
    for (int i = 0; i < n; ) {

      if (stack.isEmpty() || stack.peek() != str.charAt(i)) {
        stack.push(str.charAt(i));

        i++;
      } else {
        while (i < n && !stack.isEmpty() && stack.peek() == str.charAt(i)) {
          i++;
          stack.pop();
        }
      }
    }
    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();

  }
}