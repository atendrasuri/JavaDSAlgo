package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
https://leetcode.com/problems/combinations/description
 */
public class Soln_41_77_Combinations {
    public static void main(String[] args) {

        combine(4, 2).stream().flatMap(List::stream).forEach(x-> System.out.print(" "+x));


    }
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<>();

        compute(n, k, results, new ArrayList<>(), 1);
        return results;
    }

    public static void compute(int n, int k, List<List<Integer>> results, List<Integer> result, int firstNum){

        if(result.size()==k){
            results.add(new ArrayList<>(result));
            return;
        }

        for(int num = firstNum; num<=n; num++){
            result.add(num);
            compute(n, k, results, result, num+1);
            result.remove(result.size()-1);
        }
    }
}
