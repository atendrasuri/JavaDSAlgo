package com.suri.companyWise.amazom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

  public static void main(String[] args) {
    int nums[] = {2, 3, 6, 7};
    int target = 7;
    System.out.println(combinationSum(nums, target));

  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {


    List<List<Integer>> result = new ArrayList<>();

    if (candidates == null || candidates.length == 0 || target == 0) {

      return result;
    }

    Arrays.sort(candidates);


    List<Integer> combinations = new ArrayList<>();

    toFindCombinationsToTarget(result, combinations, target, candidates, 0);

    return result;

  }

  public static void toFindCombinationsToTarget(List<List<Integer>> result, List<Integer> combinations, int target, int[] candidates, int startIndex) {


    if (target == 0) {
      result.add(new ArrayList<>(combinations));
    }


    for (int i = startIndex; i < candidates.length; i++) {

      if (candidates[i] > target) {
        break;
      }
      combinations.add(candidates[i]);
      toFindCombinationsToTarget(result, combinations, target - candidates[i], candidates, i);

      combinations.remove(combinations.size() - 1);
    }
  }
}