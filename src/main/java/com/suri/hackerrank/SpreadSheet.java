package com.suri.hackerrank;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SpreadSheet {
  public static void main(String[] args) {
    System.out.println(getColumnName(27));

  }


  public static String getColumnName(int n)
  {
    // initalize output String as empty
    StringBuilder res = new StringBuilder();

    int count =0;

    while (n > 0)
    {
      count++;
      // find index of next letter and concatenate the letter
      // to the solution

      // Here index 0 corresponds to 'A' and 25 corresponds to 'Z'
      int index = (n-1) % 26;
      res.append((char)(index + 'A'));
      n = (n-1) /26 ;
    }

    res.append(--count);
    return res.reverse().toString();
  }
}