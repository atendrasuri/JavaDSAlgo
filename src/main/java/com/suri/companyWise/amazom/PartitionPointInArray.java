package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an unsorted array of integers. Find an element such that all the elements to its left are smaller and to its right are greater. Print -1 if no such element exists.
 * <p>
 * Note that there can be more than one such elements. For example an array which is sorted in increasing order all elements follow the property. We need to find only one such element.
 */
public class PartitionPointInArray {
  public static void main(String[] args) {

    int arr[] = {4, 3, 2, 5, 8, 6, 7};

    System.out.println(findPartitionPoint(arr));
  }

  public static int findPartitionPoint(int arr[]) {

    int left[] = new int[arr.length];
    int right[] = new int[arr.length];

    left[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {

      left[i] = Math.max(left[i - 1], arr[i]);
    }

    right[right.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {

      right[i] = Math.min(right[i + 1], arr[i]);
    }

    for (int i = 0; i < arr.length; i++) {
      if (left[i] == right[i]) {
        return left[i];
      }
    }

    return -1;

  }


}