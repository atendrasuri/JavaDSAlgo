package com.suri.leetcode.easy;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

https://leetcode.com/problems/valid-palindrome/description/
 */
public class Soln_125_Valid_Palindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {


        char [] arr = s.toLowerCase().toCharArray();

        int i=0;
        int j = arr.length-1;


        while(i<j){

            if(!isAlphaNumeric(arr[i])){
                i++;
                continue;
            }

            if(!isAlphaNumeric(arr[j])){
                j--;
                continue;
            }

            if(arr[i++]!=arr[j--]){
                return false;
            }

        }
        return true;

    }

    public static boolean isAlphaNumeric(char x){

        if((x>='a' && x<='z')|| (x>='0' && x<='9')){
            return  true;
        }
        return false;
    }
}
