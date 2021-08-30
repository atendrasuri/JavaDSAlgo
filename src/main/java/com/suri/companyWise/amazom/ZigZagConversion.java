package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * reference :- https://www.youtube.com/watch?v=7UQ71uwQFx4&list=PLV8H0QrJHjOmhbwotwt3Sy8qlfzqGhVW-&index=6
 */
public class ZigZagConversion {
  public static void main(String[] args) {

    String str = "PAYPALISHIRING";
    int numRows = 3;
    System.out.println(convert(str, numRows));

  }

  public static String convert(String s, int numRows) {

    int length = s.length();

    if (numRows > length || numRows <= 1) {
      return s;
    }
    char zigZagChars[] = new char[length];
    int count = 0;

    int interval = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      int step = interval - 2 * i;
      for (int j = i; j < length; j += interval) {
        zigZagChars[count] = s.charAt(j);
        count++;

        if (step > 0 && step < interval && j + step < length) {
          zigZagChars[count] = s.charAt(j + step);
          count++;
        }

      }

    }

    return new String(zigZagChars);
  }
}