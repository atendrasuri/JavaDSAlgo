package com.suri.leetcode.medium;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.
Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
https://leetcode.com/problems/decode-ways/

 */
public class Soln_91_Decode_Ways {
    public static void main(String[] args) {

    /*char digits[] = {'1', '2', '3', '4'};
    int n = digits.length;
    System.out.println("Count is " +
            decode(String.valueOf(digits)));*/

         System.out.println(decodeSecondApproach("121"));

        //System.out.println(decodeSecondApproach("21123"));
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
        dp[1] =s.charAt(0)=='0'?0:1;

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
