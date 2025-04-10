package com.suri.leetcode.medium;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/description/
Given an array of strings strs, group the
anagrams
 together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]
 */
public class Soln_49_Group_Anagrams {
    public static void main(String[] args) {

        String str[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>>  result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            char [] charArray = str.toCharArray();

            Arrays.sort(charArray);

            String key = new String(charArray);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        result.addAll(map.values());
        return result;

    }
}
