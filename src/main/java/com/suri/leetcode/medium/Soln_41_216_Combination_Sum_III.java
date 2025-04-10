package com.suri.leetcode.medium;
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.


https://leetcode.com/problems/combination-sum-iii
 */

import java.util.ArrayList;
import java.util.List;

public class Soln_41_216_Combination_Sum_III {
    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum3(3, 9);
        System.out.println(results);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> results = new ArrayList<>();
        combination(results, new ArrayList<>(), k, n, 1);
        return results;
    }

    public static void combination(List<List<Integer>> results, List<Integer> result, int k, int target, int start){

        if(result.size()==k && target==0){
            results.add(new ArrayList<>(result));
            return;
        }

        if(target<0 || result.size()>k){
            return;
        }

        for(int i = start; i<=9;i++){
            result.add(i);
            combination(results, result, k, target-i, i+1);
            result.remove(result.size()-1);
        }
    }

}
