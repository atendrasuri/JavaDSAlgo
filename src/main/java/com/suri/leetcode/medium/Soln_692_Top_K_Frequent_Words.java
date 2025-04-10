package com.suri.leetcode.medium;


/*

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.



Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 */

import java.util.*;

public class Soln_692_Top_K_Frequent_Words {

    public static void main(String[] args) {

        String [] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};

        System.out.println(topKFrequent(words, 2));

    }

    public static List<String> topKFrequent(String[] words, int k) {


        Map<String, Integer> map = new HashMap<>();

        List<String> result = new ArrayList<>();

        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) ->  b.getValue() - a.getValue());


        priorityQueue.addAll(map.entrySet());

        while(!priorityQueue.isEmpty() && result.size()<k){
            result.add(priorityQueue.remove().getKey());
        }

        return result;

    }
}
