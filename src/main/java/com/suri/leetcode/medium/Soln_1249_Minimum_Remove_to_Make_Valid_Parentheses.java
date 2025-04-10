package com.suri.leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses

Algorithm

Let's put all this together into a 2-pass algorithm.

Identify all indexes that should be removed.
Build a new string with removed indexes.
As explained above, we should use a stack. If we put the indexes of the "(" on the stack, then we'll know that all the indexes on the stack at the end are the indexes of the unmatched "(". We should also use a set to keep track of the unmatched ")" we come across. Then, we can remove the character at each of those indexes and then return the edited string.

We need to be really careful with that "removal" step though, as it can be done in O(n), but there are many ways of accidentally making it O(n
2
 ). Making these mistakes (and not fixing them) in an interview won't look good. Here's some operations that are O(n) that people sometimes assume are O(1).

Adding or removing (or even changing) just one character anywhere in a string is O(n), because strings are immutable. The entire string is rebuilt for every change.
Adding or removing not from the end of a list, vector, or array is O(n) because the other items are moved up to make a gap or down to fill in the gap.
Checking if an item is in a list, because this requires a linear search. Even if you use binary search, it'll still be O(logn), which is not ideal for this problem.
A safe strategy is to iterate over the string and insert each character we want to keep into a list (Python) or StringBuilder (Java). Then once we have all the characters, it is a single O(n) step to convert them into a string.

Recall that checking if an item is in a set is O(1). If all the indexes we need to remove are in a set, then we can iterate through each index in the string, check if the current index is in the set, and if it is not, then add the character at that index to the string builder
 */
public class Soln_1249_Minimum_Remove_to_Make_Valid_Parentheses {

    public static void main(String[] args) {

        String str = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(str));

    }
    public static String minRemoveToMakeValid(String s) {

        Set<Integer> indexesToRemove = new HashSet<>();

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){
                stack.push(i);
            }
            if(s.charAt(i)==')'){

                if(stack.isEmpty()){
                    indexesToRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){

            if(!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }
}
