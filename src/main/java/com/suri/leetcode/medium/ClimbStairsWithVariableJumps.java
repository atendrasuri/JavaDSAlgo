package com.suri.leetcode.medium;

/*


https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3&ab_channel=Pepcoding
 */
public class ClimbStairsWithVariableJumps {

    public static void main(String[] args) {


    }

    public static int climbStairs(int n, int arr[]) {

        int dp[] = new int[n + 1];

        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }


}
