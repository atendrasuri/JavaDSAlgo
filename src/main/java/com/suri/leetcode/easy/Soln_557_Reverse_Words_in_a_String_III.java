package com.suri.leetcode.easy;
/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"


Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
https://leetcode.com/problems/reverse-words-in-a-string-iii

 */
public class Soln_557_Reverse_Words_in_a_String_III {
    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));

    }
    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        String [] strs = s.split(" ");

        for(int idx=0; idx<strs.length; idx++){

            char[] charArr = strs[idx].toCharArray();

            for(int i=0;i<charArr.length/2; i++){

                char temp = charArr[i];
                charArr[i]= charArr[charArr.length-i-1];
                charArr[charArr.length-i-1] = temp;
            }

            sb.append(new String(charArr));

            if(idx!=strs.length-1){
                sb.append(" ");
            }
        }

        System.out.println(" "+sb.toString());
        return sb.toString();
    }
}
