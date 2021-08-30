package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
  public static void main(String[] args) {

    int set[] = {1, 2, 3};

    System.out.println(subsets(set));

  }

  public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    int setSize = nums.length;
    int powerSetSize = (int) Math.pow(2, setSize);

    int counter;
    int j = 0;

    for (counter = 0; counter < powerSetSize; counter++) {
      ArrayList<Integer> list = new ArrayList<>();
      for (j = 0; j < setSize; j++) {

        if ((counter & (1 << j)) > 0) {
          list.add(nums[j]);
        }
      }
      result.add(list);
    }
    return result;
  }
}