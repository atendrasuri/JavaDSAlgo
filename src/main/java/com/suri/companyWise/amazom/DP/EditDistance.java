package com.suri.companyWise.amazom.DP;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/02/19
 * @Description: (Overwrite)
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * @History:
 */
public class EditDistance {

    public static void main(String[] args) {

        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(""+ editDistDP( str1 , str2));

    }

    public static int editDistDP(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m + 1][n + 1];


        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }
                else{
                    dp[i][j]= 1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }

         return dp[m][n];

    }
}