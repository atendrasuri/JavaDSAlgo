package com.suri.leetcode.medium;

import java.util.Stack;
/*

You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.


Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
https://leetcode.com/problems/removing-stars-from-a-string
 */
public class Soln_2390_Removing_Stars_From_a_String {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));

    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch!='*'){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();

    }
}
