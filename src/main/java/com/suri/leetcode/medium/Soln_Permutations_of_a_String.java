package com.suri.leetcode.medium;
/*
Given a string s. The task is to return a vector of string of all unique permutations of the given string, s that may contain duplicates in lexicographically sorted order.

Examples:

Input: "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has permutations in 6 forms as "ABC", "ACB", "BAC", "BCA", "CAB" and "CBA".
Input: "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 permutations.
Input: "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
https://www.geeksforgeeks.org/problems/permutations-of-a-given-string
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Soln_Permutations_of_a_String {
    public static void main(String[] args) {
        System.out.println(findPermutation("ABC"));

    }

    public static List<String> findPermutation(String s) {

        Set<String> result = new HashSet<>();
        List<String> mainList = new ArrayList<>();
        if(s.length()==0){
            return mainList;
        }

        compute(result, "", s);
        mainList.addAll(result);
        return mainList;

        // Code here
    }

    public static void compute( Set<String> results , String result, String str){

        if(str.length()==0){
            results.add(result);
            return;
        }

        for(int i=0;i<str.length();i++){
            if(i > 0 && str.charAt(i) == str.charAt(i-1)) continue; // Skip the same character to avoid duplicate permutations
            compute( results, result+str.charAt(i), str.substring(0,i)+str.substring(i+1));
        }
    }
}
