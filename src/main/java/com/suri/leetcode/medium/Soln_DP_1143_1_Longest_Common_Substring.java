package com.suri.leetcode.medium;
/*

Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

Examples :

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
Explanation:
The longest common substring is “abcdez” and is of length 6.

https://www.geeksforgeeks.org/longest-common-substring-dp-29/

   OR

Longest common subarray in the given two arrays
Difficulty Level : Medium
Last Updated : 23 Dec, 2021
Given two arrays A[] and B[] of N and M integers respectively, the task is to find the maximum length of equal subarray or the longest common subarray between the two given array.

Examples:

Input: A[] = {1, 2, 8, 2, 1}, B[] = {8, 2, 1, 4, 7}
Output: 3
Explanation:
The subarray that is common to both arrays are {8, 2, 1} and the length of the subarray is 3.
Input: A[] = {1, 2, 3, 2, 1}, B[] = {8, 7, 6, 4, 7}
Output: 0
Explanation:
There is no such subarrays which are equal in the array A[] and B[].


https://www.geeksforgeeks.org/longest-common-subarray-in-the-given-two-arrays/


https://www.youtube.com/watch?v=NvmJBCn4eQI&ab_channel=Pepcoding
 */
public class Soln_DP_1143_1_Longest_Common_Substring {

    public static void main(String[] args) {

        String str1 = "GeeksforGeeks";
        String str2 =  "GeeksQuiz";

        System.out.println(longestCommonSubString(str1, str2));

        int arr1[] = {1, 2, 8, 2, 1};
        int arr2[] = {8, 2, 1, 4, 7};
        System.out.println(longestCommonSubArray(arr1, arr2));

    }

    public static int longestCommonSubString(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = str1.charAt(i - 1);
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static int longestCommonSubArray(int arr1[], int arr2[]) {

        int m = arr1.length;
        int n = arr2.length;

        int dp[][] = new int[m+1][n+1];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(arr1[i-1]== arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] =0;
                }
               max = Math.max(max, dp[i][j]);
            }
        }

     return max;
    }
}
