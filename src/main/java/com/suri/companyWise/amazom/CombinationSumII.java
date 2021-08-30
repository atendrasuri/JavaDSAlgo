package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {

  public static void main(String[] args) {

    int arr[] = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    System.out.println(combinationSum2(arr, target));

  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    if (candidates.length == 0 || candidates == null) {
      return result;
    }

    findCombinations(candidates, 0, target, new ArrayList<>(), result);

    return result;

  }

  public static void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {

    if (target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }
    if (target < 0) {
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (i == index || candidates[i] != candidates[i - 1]) {
        current.add(candidates[i]);
        findCombinations(candidates, i + 1, target - candidates[i], current, result);
        current.remove(current.size() - 1);
      }

    }
  }
}