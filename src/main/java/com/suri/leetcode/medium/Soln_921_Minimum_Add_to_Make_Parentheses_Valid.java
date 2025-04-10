package com.suri.leetcode.medium;

import java.util.Stack;

/**


 A parentheses string is valid if and only if:

 It is the empty string,
 It can be written as AB (A concatenated with B), where A and B are valid strings, or
 It can be written as (A), where A is a valid string.
 You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

 For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 Return the minimum number of moves required to make s valid.



 Example 1:

 Input: s = "())"
 Output: 1
 Example 2:

 Input: s = "((("
 Output: 3

 https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 https://www.youtube.com/watch?v=e7HyTdHAf4U&ab_channel=Pepcoding
 */

public class Soln_921_Minimum_Add_to_Make_Parentheses_Valid {

    public static void main(String[] args) {

    }

    public static int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }else{
                // that means ch ==)
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        return stack.size();

    }
}
