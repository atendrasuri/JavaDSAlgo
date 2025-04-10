package com.suri.leetcode.easy;

/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

https://leetcode.com/problems/add-binary/description
 */
public class Soln_67_Add_Binary {

    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));

    }

    public static String addBinary(String a, String b) {


        int maxLength= Math.max(a.length(), b.length());

        StringBuilder result = new StringBuilder();

        int carry=0;

        for(int i=0;i<maxLength;i++){

            int digitA = (i<a.length())? a.charAt(a.length()-i-1)-'0':0;
            int digitB = (i<b.length())?b.charAt(b.length()-i-1)-'0':0;

            int sum = digitA+digitB+carry;

            result.append(sum%2);
            carry = sum/2;


        }

        if(carry>0){
            result.append(carry);
        }

        return result.reverse().toString();

    }
}
