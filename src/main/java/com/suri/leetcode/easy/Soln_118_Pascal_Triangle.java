package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 Given an integer numRows, return the first numRows of Pascal's triangle.

 In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 Example 1:

 Input: numRows = 5
 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 Example 2:

 Input: numRows = 1
 Output: [[1]]

 * https://leetcode.com/problems/pascals-triangle/description
 */
public class Soln_118_Pascal_Triangle {
  public static void main(String[] args) {

    System.out.println(generate(5));

  }

  public static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> result = new ArrayList<>();

    if (numRows == 0) {
      return result;
    }

    int dp[][] = new int[numRows][numRows];

    dp[0][0] = 1;

    List<Integer> list1 = new ArrayList<>();
    list1.add(dp[0][0]);
    result.add(list1);
    for (int i = 1; i < numRows; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j <= i; j++) {

        if (j == 0 || j == i) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        list.add(dp[i][j]);
      }
      result.add(list);
    }
    return result;
  }
}