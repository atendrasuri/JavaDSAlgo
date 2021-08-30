package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/03/19
 * @Description: (Overwrite)
 * Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.
 * Examples:
 * <p>
 * Input:  digits[] = "121"
 * Output: 3
 * // The possible decodings are "ABA", "AU", "LA"
 * <p>
 * Input: digits[] = "1234"
 * Output: 3
 * // The possible decodings are "ABCD", "LCD", "AWD"
 */
public class PossibleDecodingOfGivenDigit {
  public static void main(String[] args) {

    /*char digits[] = {'1', '2', '3', '4'};
    int n = digits.length;
    System.out.println("Count is " +
            decode(String.valueOf(digits)));*/

    System.out.println(decodeSecondApproach("121"));
  }

  public static int decode(String input) {

    int len = input.length();

    int[] decodeCount = new int[len + 1];

    decodeCount[0] = 1;
    decodeCount[1] = 1;

    for (int i = 2; i < len + 1; i++) {

      if (input.charAt(i - 1) > '0') {
        decodeCount[i] = decodeCount[i - 1];
      }

      if (input.charAt(i - 2) < '2' || input.charAt(i - 2) == '2' && input.charAt(i - 1) < '7') {
        decodeCount[i] = decodeCount[i] + decodeCount[i - 2];
      }
    }
    return decodeCount[len];
  }

  public static int decodeSecondApproach(String s) {

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = dp[1]=s.charAt(0)=='0'?0:1;

    for (int i = 2; i <= s.length(); i++) {

      int oneDigit = Integer.valueOf(s.substring(i - 1, i));
      int twoDigits = Integer.valueOf(s.substring(i - 2, i));

      if (oneDigit >= 1) {
        dp[i] += dp[i - 1];
      }
      if (twoDigits >= 10 && twoDigits <= 26) {
        dp[i] += dp[i - 2];
      }


    }
    return dp[s.length()];

  }
}