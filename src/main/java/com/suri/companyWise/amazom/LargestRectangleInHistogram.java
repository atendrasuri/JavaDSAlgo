package com.suri.companyWise.amazom;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3]
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * <p>
 * <p>
 * <p>
 * 1) Create an empty stack.
 * <p>
 * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
 * ……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
 * ……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
 * <p>
 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 */
public class LargestRectangleInHistogram {
  public static void main(String[] args) {

    int arr[] = {2, 1, 5, 6, 2, 3};
    LargestRectangleInHistogramSoln largestRectangleInHistogramSoln = new LargestRectangleInHistogramSoln();
    System.out.println(largestRectangleInHistogramSoln.largestRectangleArea(arr));
  }
}

class LargestRectangleInHistogramSoln {

  public int largestRectangleArea(int[] arr) {


    int toparea = 0;
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int i = 0;
    for (; i < n; ) {

      if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
        stack.push(i++);
      } else {

        int top = stack.pop();

        if (stack.isEmpty()) {
          toparea = arr[top] * i;
        } else {
          toparea = arr[top] * (i - stack.peek() - 1);
        }
      }

      if (toparea > maxArea) {
        maxArea = toparea;
      }
    }

    while (!stack.isEmpty()) {
      int top = stack.pop();

      if (stack.isEmpty()) {
        toparea = arr[top] * i;
      } else {
        toparea = arr[top] * (i - stack.peek() - 1);
      }


      if (toparea > maxArea) {
        maxArea = toparea;
      }
    }
    return maxArea;
  }
}