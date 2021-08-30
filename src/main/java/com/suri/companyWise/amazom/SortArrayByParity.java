package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {
  public static void main(String[] args) {
    int arr[] = {3, 1, 2, 4};

    int result[] = sortArrayByParity(arr);

    for (int a : result) {
      System.out.print(a+" ");
    }

  }

  public static int[] sortArrayByParity(int[] A) {

    int index = 0;

    for (int i = 0; i < A.length; i++) {

      if (A[i] % 2 == 0) {
        int temp = A[index];
        A[index++] = A[i];
        A[i] = temp;
      }
    }
    return A;

  }
}