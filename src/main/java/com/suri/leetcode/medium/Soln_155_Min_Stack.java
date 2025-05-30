package com.suri.leetcode.medium;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
https://leetcode.com/problems/min-stack/description
 */

import java.util.Stack;

public class Soln_155_Min_Stack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

}
class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int x) {

        if(stack.isEmpty()){

            stack.push(new int[]{x,x});
            return;
        }

        int currentMin = stack.peek()[1];

        stack.push(new int[]{x, Math.min(x, currentMin)});

    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        return stack.peek()[0];

    }

    public int getMin() {
        return stack.peek()[1];
    }
}
