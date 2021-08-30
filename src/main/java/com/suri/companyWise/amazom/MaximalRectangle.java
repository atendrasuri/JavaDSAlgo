package com.suri.companyWise.amazom;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 * <p>
 * hint:- use maximum rectangle in histogram.
 */
public class MaximalRectangle {
  public static void main(String[] args) {
    String matrix[][] = {{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}};
    System.out.println(maximalRectangle(matrix));

  }

  public static int maximalRectangle(String[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int rLen = matrix.length;
    int cLen = matrix[0].length;
    int height[] = new int[cLen + 1];
    int max = 0;
    for (int row = 0; row < rLen; row++) {

      Stack<Integer> s = new Stack<Integer>();

      for (int i = 0; i < cLen + 1; i++) {
        if (i < cLen) {
          if (matrix[row][i] == "1") {
            height[i] = height[i] + 1;

          } else {
            height[i] = 0;
          }
        }
        if (s.isEmpty() || height[s.peek()] < height[i]) {
          s.push(i);
        } else {
          while (!s.isEmpty() && height[i] < height[s.peek()]) {
            int top = s.pop();
            int area = height[top] * (s.isEmpty() ? i : (i - s.peek() - 1));
            if (area > max)
              max = area;
          }
          s.push(i);
        }
      }
    }
    return max;

  }
}