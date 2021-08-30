package com.suri.companyWise.amazom;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
 * <p>
 * Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
 * Output: 1
 * <p>
 * Explanation:
 * To bring elements 2, 1, 3 together, swap
 * element '5' with '3' such that final array
 * will be-
 * arr[] = {2, 1, 3, 6, 5}
 * <p>
 * Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
 * Output: 2
 */
public class MinSwapRequiredToBringAllTogether {
  public static void main(String[] args) {

    List<Integer> list1 = Arrays.asList(2, 1, 5, 6, 3);
    int k = 3;

    List<Integer> list2 = Arrays.asList(2, 7, 9, 5, 8, 7, 4);
    int k2 = 5;

    System.out.println(solve(list1, k));
    System.out.println(solve(list2, k2));

  }

  public static int solve(List<Integer> A, int B) {

    int count = 0;

    for (int a : A) {
      if (a <= B) {
        count++;
      }

    }
    int bad = 0;

    for (int i = 0; i < count; i++) {
      if (A.get(i) > B) {
        bad++;
      }

    }

    int ans = bad;

    for (int i = 0, j = count; j < A.size(); i++, j++) {

      if (A.get(i) > B) {
        bad--;
      }
      if (A.get(j) > B) {
        bad++;
      }
      ans = Math.min(ans, bad);
    }

    return ans;
  }
}

