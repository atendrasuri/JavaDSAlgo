package com.suri.leetcode.medium;

/**

https://leetcode.com/problems/remove-all-occurrences-of-a-substring

Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.



Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".
 */

public class Soln_1910_Remove_All_Occurrences_of_a_Substring {

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));

    }

    public static String removeOccurrences(String s, String part) {

        int endIndex =0;
        int m = part.length();

        StringBuilder result = new StringBuilder();
        while(s.indexOf(part)>=0){
            int idx = s.indexOf(part);
            if( idx >=0){
                s = s.substring(0, idx) +s.substring(idx+m, s.length());
                endIndex = endIndex+1;
            }else{
                endIndex = endIndex+1;
            }
        }
        return s;
    }
}
