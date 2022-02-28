package com.suri.datastructure.stacks;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/08/19
 * @Description: (Overwrite)
 * 1. Implement a stack with operations min, push, pop and top in O(1)
 * @History:
 */
public class MinimumStack {
  public static void main(String[] args) {
    MinStack mStack = new MinStack();
    mStack.push(7);
    mStack.push(8);
    System.out.println(mStack.min());
    mStack.push(5);
    mStack.push(9);
    System.out.println(mStack.min());
    mStack.push(5);
    mStack.push(2);
    System.out.println(mStack.min());
    mStack.pop();
    mStack.pop();
    System.out.println(mStack.min());

  }
}

class MinStack {

  class Node {

    int value;
    int min;
    Node next;


    Node(int x) {
      this.value = x;
      min = x;
      next = null;
    }

  }


  Node top;

  public void push(int x) {

    if (top == null) {
      top = new Node(x);
    } else {
      Node temp = new Node(x);
      temp.next = top;
      temp.min = Math.min(top.min, x);
      top = temp;
    }
  }


  public void pop() {

    if (top == null) {
      System.out.println("Stack is Empty");
      return;
    }


    top = top.next;
  }

  public int top() {
    if (top == null) {
      System.out.println("Stack is Empty");
      return Integer.MAX_VALUE;
    }
    return top.value;
  }

  public int min() {

    if (top == null) {
      System.out.println("Stack is Empty");

      return Integer.MIN_VALUE;
    }
    return top.min;
  }

}