package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Let’s work through the following problem.
 *
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 *
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 *
 * For example, if N is 4, then there are 5 unique ways:
 *
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 *
 *
 * Soln:- fibanacci seeries
 *
 * if M=3(i.e, 3 steps at a time)
 * then f(n) = f(n-1)+f(n-2)+f(n-3)
 *
 * if M=4(i.e, 4 steps at time)
 *then f(n) = f(n-1)+f(n-2)+f(n-3)+f(n-4)
 * and so. on
 */
public class StairCaseProblem {

    public static void main(String[] args) {

        int N=4;
        int arr[] = new int[N];

        arr[0]=1;
        arr[1]=2;

        for(int i=2;i<N;i++){

            arr[i]= arr[i-1]+arr[i-2];
        }
        System.out.println(arr[N-1]);

        System.out.println(climbStairs(4));
    }

  public static int climbStairs(int n) {

    int dp[]= new int[n+1];

    dp[0]=1;
    dp[1]=1;
    int i=0;
    for( i=2;i<=n;i++){
      dp[i]= dp[i-1]+dp[i-2];
    }
    return dp[i-1];
  }
}