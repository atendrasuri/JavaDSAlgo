package com.suri.leetcode.medium;

import java.util.Arrays;

/*
There are 'n' number of trees(plants) in a row.
We need 'x' length of wood(log) from the trees.
You can choose a particular height('h', a whole number) at which all the trees(taller than 'h') will get cut.
At what height you'll make the cut so that minimum amount of wood will be cut.
Given:

* A list of numbers representing the height of trees in a row.
* A number representing the total length of wood we require.
Output:
* Height at which you'll make a cut so as to minimize the wastage of wood.


e.g.

n = 5
[10 11 12 13 14]
x = 13

 H
 n
 H * n
H * log (n)


h = 9
 */
public class MyCode {
    public static void main(String[] args) {
        int arr[] = {10, 11, 12, 13, 14};
        int x = 13;
        System.out.println(minimumCut(arr, x));



    }


    public static int minimumCut(int arr[], int x) {
        int result = Integer.MAX_VALUE;
        int n = arr.length;
        int high = getMax(arr, n);
        int low = 0;
        while (low <= high) {
           int mid = (high + low) / 2;
            int sum = tootalCutSumOfTree(arr, mid, n);
            if (sum >= x) {
                result = mid;

            }
            if (sum > x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private static int tootalCutSumOfTree(int arr[], int cut, int n){
        int sum =0;
        for(int i=0;i<n;i++){
            if(arr[i]-cut <=0){
                break;
            }
            sum+= (arr[i]-cut);
        }
        return sum;
    }

    public static int getMax(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
