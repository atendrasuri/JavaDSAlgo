package com.suri.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an array arr and an integer k. You have to find the maximum product of k contiguous elements in the array.

Examples:

Input: arr[] = [1, 2, 3, 4] and k = 2
Output: 12
Explanation: The sub-array of size 2 will be 3 4 and the product is 12.
Input: arr[] = [1, 6, 7, 8] and k = 3
Output: 336
Explanation: The sub-array of size 3 will be 6 7 8 and the product is 336.
Expected Time Complexity: O(n)
Expected Auxilary Space: O(1)

https://www.geeksforgeeks.org/problems/largest-product
 */
public class Soln_239_Max_Product_subArray_K {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4};
        int k=2;
        System.out.println(findMaxProduct(arr, k));

    }

    public static int findMaxProduct(int[] arr, int k) {
        int currentProduct = 1;
        int  maxProduct = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>(k);

        for(int i=0;i<k;i++){
            currentProduct = currentProduct*arr[i];
            list.add(currentProduct);

        }

        for(int i=k;i<arr.length;i++){
            currentProduct= currentProduct*arr[i];

            maxProduct = Integer.MIN_VALUE;

            for(int j=0;j<list.size();j++){
                maxProduct = Math.max(maxProduct, list.get(j));
            }
            list.remove(0);
            list.add(currentProduct);
        }
        maxProduct = Integer.MIN_VALUE;
        for(int j=0;j<list.size();j++){
            maxProduct = Math.max(maxProduct, list.get(j));
        }
        return maxProduct;
    }

}
