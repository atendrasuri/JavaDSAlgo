package com.suri.interview;

/*
if i had given the maximum weight say w=20 .and i had given a set on weights say m=[5,7,12,18] then how could i calculate the max possible weight that we can hold inside the maximum weight using the m. in this case the answer is 19.by adding 12+7=19.

https://stackoverflow.com/questions/36200214/knapsack-with-weight-only
https://leetcode.com/discuss/interview-question/858129/roblox-oa-new-grad-2021
https://www.youtube.com/watch?v=nq-tpLKkA6g&ab_channel=JavaCodingInsightInterviewPreparation
 */
public class Soln_Lifting_Weights {
    public static void main(String[] args) {

        int weight1[] = {5,7,12,18};
        System.out.println(weightCapacity(weight1, 20)==19);

        int weight2[] = {1,3,5};
        System.out.println(weightCapacity(weight2, 7)==6);
    }

    public static int weightCapacity(int weight[], int maxCapacity) {

        int n = weight.length;


        int dp[][] = new int[n + 1][maxCapacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + weight[i - 1], dp[i - 1][j]);
                }

            }
        }
        return dp[n][maxCapacity];
    }
}
