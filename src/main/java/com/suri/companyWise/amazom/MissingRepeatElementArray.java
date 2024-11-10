package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in array.
 * Find these two numbers.
 * @History:
 */
public class MissingRepeatElementArray {

    public static void main(String[] args) {

        int arr[] = {5,1,6,2,3,3};
        findMissingNRepeatElement(arr);


    }

    public static void findMissingNRepeatElement(int arr[]) {


        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0) {
                arr[abs_val - 1] = -arr[abs_val - 1];
            } else {
                System.out.println("Repeating element " + abs_val);
            }
        }

        System.out.println("Array element");
        for(int i=0;i<arr.length;i++){
            System.out.println("  "+ arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                System.out.println("Missing element " + (i + 1));
            }
        }

    }
}