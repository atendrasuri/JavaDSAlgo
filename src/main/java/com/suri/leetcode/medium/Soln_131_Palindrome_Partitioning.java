package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every
substring
 of the partition is a
palindrome
. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class Soln_131_Palindrome_Partitioning {
  public static void main(String[] args) {


    System.out.println(partition("aab"));

  }
  public static List<List<String>> partition(String s) {
    List<List<String>> results = new ArrayList<>();
    compute(s, results, new ArrayList<>(), 0);
    return results;
  }

  public static void compute(String s, List<List<String>>  results, List<String> result, int start){

    if(start==s.length()){
      results.add(new ArrayList<>(result));
      return;
    }

    for(int end = start; end<s.length(); end++){
      if(isPalindrome(s.substring(start, end+1))){
        result.add(s.substring(start, end+1));
        compute(s, results, result, end+1);
        result.remove(result.size()-1);
      }

    }
  }

  public static boolean isPalindrome(String s){

    int left = 0;
    int right= s.length()-1;

    while(left<right){
      if(s.charAt(left)!= s.charAt(right)){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
