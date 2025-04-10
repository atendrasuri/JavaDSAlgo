package com.suri.interview;

import java.util.*;

/**

 */
public class FinalDiscountedPrice {
    public static void main(String[] args) {

        int arr[] = {2, 3, 1, 2, 4, 2};
        int arr1[] = {5, 1, 3, 4, 6, 2};

         finalDiscountedPrice(arr);
         finalDiscountedPrice(arr1);


    }


    public static void finalDiscountedPrice(int prices[]) {

        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int totalDiscountedPrice = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[i]<=prices[stack.peek()]) {
                int r = prices[stack.pop()];
                totalDiscountedPrice += r - prices[i];
            }

            stack.push(i);
        }

        // for the items which sells without discount
        Set<Integer> list= new TreeSet<>();
        while (!stack.isEmpty()) {
            int i=stack.pop();
            list.add(i);
            totalDiscountedPrice += prices[i];
        }
        System.out.println(""+ totalDiscountedPrice);
        System.out.println(list);

    }
}