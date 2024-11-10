package com.suri.companyWise.google;

/*
Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation:
The maximum obtainable value is
24 by cutting the rod into 8 pieces
of length 1, i.e, 8*3=24.

https://www.youtube.com/watch?v=eQuJb5gBkkc&ab_channel=Pepcoding

https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
https://leetcode.com/discuss/interview-question/1271572/rod-cutting-dp
 */
public class Soln_Rod_Cutting {
    public static void main(String[] args) {

        int Price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(Price, 8));
    }

    public static int cutRod(int price[], int n) {
        //code here


        int np[] = new int[n+1];

        for(int i=0;i<n;i++){

            np[i+1] = price[i];
        }

        int dp[] = new int[np.length];



        dp[0]=0;
        dp[1] = np[1];

        for(int i=2;i<dp.length;i++){


            dp[i] = np[i];

            int li = 1;
            int ri = i-1;

            while(li<=ri){

                if(dp[li]+dp[ri]> dp[i]){
                    dp[i] = dp[li]+dp[ri];
                }
                li++;
                ri--;

            }
        }

        return dp[dp.length-1];
    }
}
