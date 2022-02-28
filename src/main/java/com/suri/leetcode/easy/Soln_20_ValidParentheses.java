package com.suri.leetcode.easy;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
https://leetcode.com/problems/valid-parentheses/

 */
public class Soln_20_ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid( "(]"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {

        if(s.length()==0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        int n = s.length();

        for(int i=0;i<n;i++){

            char c = s.charAt(i);

            if(c=='(' || c=='{' || c=='['){

                stack.push(c);
            }else{

                if(c==')' || c=='}' || c==']'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(!isMatching(stack.pop(), c)){
                        return false;
                    }

                }
            }

        }

        if(stack.isEmpty()){
            return true;
        }
        return false;


    }

    public static boolean isMatching(char op1, char op2){

        if(op1=='(' && op2==')'){
            return true;
        }
        if(op1=='{' && op2=='}'){
            return true;
        }
        if(op1=='[' && op2==']'){
            return true;
        }

        return false;

    }
}
