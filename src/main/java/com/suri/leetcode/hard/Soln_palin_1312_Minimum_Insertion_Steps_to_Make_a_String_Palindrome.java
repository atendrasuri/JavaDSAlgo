package com.suri.leetcode.hard;

/**

 Given a string s. In one step you can insert any character at any index of the string.

 Return the minimum number of steps to make s palindrome.

 A Palindrome String is one that reads the same backward as well as forward.



 Example 1:

 Input: s = "zzazz"
 Output: 0
 Explanation: The string "zzazz" is already palindrome we do not need any insertions.
 Example 2:

 Input: s = "mbadm"
 Output: 2
 Explanation: String can be "mbdadbm" or "mdbabdm".
 Example 3:

 Input: s = "leetcode"
 Output: 5
 Explanation: Inserting 5 characters the string becomes "leetcodocteel".

 https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

 https://www.youtube.com/watch?v=xPBLEj41rFU&t=4s&ab_channel=takeUforward
 */

public class Soln_palin_1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {
    public static void main(String[] args) {

        System.out.println(minInsertions("mbadm"));


    }
    public static int minInsertions(String s) {

        String text1 = s;
        String text2 = reverse(s);


        int n = s.length();

        int [][] dp = new int[n+1][n+1];


        for(int i=0;i<=n; i++){
            for(int j =0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    if(text1.charAt(i-1)== text2.charAt(j-1)){
                        dp[i][j]= dp[i-1][j-1]+1;
                    }else{

                        dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        return s.length()- dp[n][n];

    }



    private static String reverse(String s){

        return new StringBuilder(s).reverse().toString();
    }
}
