package com.suri.leetcode.easy;
/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 */
public class Soln_28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

    }
    public static int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for(int windoStart =0;windoStart<=n-m; windoStart++){

            for(int i=0;i<m;i++){

                if(needle.charAt(i)!= haystack.charAt(windoStart+i)){
                    break;
                }
                if(i==m-1){
                    return windoStart;
                }
            }
        }
        return -1;

    }
}
