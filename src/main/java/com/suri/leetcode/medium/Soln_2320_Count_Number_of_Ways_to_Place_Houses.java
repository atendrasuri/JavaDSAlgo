package com.suri.leetcode.medium;

/*
here is a street with n * 2 plots, where there are n plots on each side of the street. The plots on each side are numbered from 1 to n. On each plot, a house can be placed.

Return the number of ways houses can be placed such that no two houses are adjacent to each other on the same side of the street. Since the answer may be very large, return it modulo 109 + 7.

Note that if a house is placed on the ith plot on one side of the street, a house can also be placed on the ith plot on the other side of the street.



Example 1:

Input: n = 1
Output: 4
Explanation:
Possible arrangements:
1. All plots are empty.
2. A house is placed on one side of the street.
3. A house is placed on the other side of the street.
4. Two houses are placed, one on each side of the street.
https://leetcode.com/problems/count-number-of-ways-to-place-houses
 */
public class Soln_2320_Count_Number_of_Ways_to_Place_Houses {

    public static void main(String[] args) {

        System.out.println(countHousePlacements(1));

    }

    public static int countHousePlacements(int n) {

        int mod = 1_000_000_007;

        long [] dp = new long[n+1];

        dp[0]=1;
        dp[1]=2;

        for(int i=2; i<=n;i++){
            dp[i]= (dp[i-1]+dp[i-2])%mod;
        }

        long result = (dp[n]*dp[n])%mod;
        return (int)result;
    }
}
