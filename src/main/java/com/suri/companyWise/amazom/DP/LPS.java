package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LPS {

    public static void main(String[] args) {

        String str = "GEEKSFORGEEKS";

        System.out.println("The lnegth of the lps is " + findLPS(str));

    }

    public static int findLPS(String str) {

        int n = str.length();

        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int cl=2; cl<=n; cl++) {

            for (int i=0; i<n-cl+1; i++) {
                int j = i+cl-1;

                if (str.charAt(i) == str.charAt(j) && cl == 2)
                    dp[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }


        }


        return dp[0][n - 1];
    }
}