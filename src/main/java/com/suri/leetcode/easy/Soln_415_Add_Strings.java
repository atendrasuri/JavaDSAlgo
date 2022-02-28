package com.suri.leetcode.easy;

/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
https://leetcode.com/problems/add-strings/
 */
public class Soln_415_Add_Strings {
    public static void main(String[] args) {
        String num1= "456";
        String num2="77";
        System.out.println(addStrings(num1, num2));

    }

    public static String addStrings(String num1, String num2) {
        int m = num1.length()-1;
        int n = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry=0;
        while(m>=0 || n>=0){
            int x = m>=0 ?num1.charAt(m)-'0':0;
            int y = n>=0?num2.charAt(n)-'0':0;
            int sum = (x+y+carry)%10;
            carry= (x+y+carry)/10;
            sb.append(sum);
            m--;
            n--;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
