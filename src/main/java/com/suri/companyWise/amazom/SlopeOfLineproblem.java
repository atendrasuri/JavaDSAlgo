package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SlopeOfLineproblem {

  public static void main(String[] args) {

    String resultString[] = {"STRICTTLYINCRESING", "STRICTTLYDECREASING", "STRICTTLYINCRESINGANDDECREASING", "STRICTTLYDECREASINGANDINCRESING"};
    int arr1[] = {1, 2, 3, 4, 6, 8, 10};
    int arr2[] = {10, 8, 6, 4, 3, 2, 1};
    int arr3[] = {1, 2, 3, 4, 10, 8, 6};
    int arr4[] = {10, 8, 6, 1, 2, 3, 4};

    int result = findTypesOfSlope(arr1);
    System.out.println(resultString[result - 1]);

    result = findTypesOfSlope(arr2);
    System.out.println(resultString[result - 1]);

    result = findTypesOfSlope(arr3);
    System.out.println(resultString[result - 1]);

    result = findTypesOfSlope(arr4);
    System.out.println(resultString[result - 1]);


  }

  public static int findTypesOfSlope(int arr[]) {


    if (arr.length == 0) {
      return -1;
    }
    int length = arr.length;

    int y2 = arr[length - 1];
    int y1 = arr[length - 2];

    int x2 = arr[1];
    int x1 = arr[0];

    int m2 = y2 - y1;
    int m1 = x2 - x1;

    if (m2 > 0 && m1 > 0) {
      return 1;
    } else if (m2 < 0 && m1 < 0) {
      return 2;
    } else if (m2 < 0 && m1 > 0) {
      return 3;
    } else if (m2 > 0 && m1 < 0) {
      return 4;
    }
    return -1;
  }
}