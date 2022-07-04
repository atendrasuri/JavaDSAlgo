package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given a list of words and two wordsword1_and_word2, return the shortest distance between these two words in the list.
Example:
Assume that words =["practice", "makes", "perfect", "coding", "makes"].
Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1

https://leetcode.com/problems/shortest-word-distance/
https://aaronice.gitbook.io/lintcode/hash-table/shortest-word-distance
 */
public class Soln_243_Shortest_Word_Distance {
    public static void main(String[] args) {

        String str = "practice makes perfect coding makes";
        String word1 = "coding";
        String word2 ="practice";
        System.out.println(shortestDistance(str, word1, word2));
    }

   public static List<String> shortestDistance(String str, String word1, String word2){
       List<String> result = new ArrayList<>();
       String strArr[] = str.split(" ");
       int begin =-1;
       int end =-1;
       int minDistance = Integer.MAX_VALUE;
       for(int i=0; i< strArr.length;i++){
           if(strArr[i].equals(word1)){
               begin=i;
           }
           if(strArr[i].equals(word2)){
               end=i;
           }
           if(begin!=-1 && end!=-1){
               minDistance = Math.min(minDistance, Math.abs(end-begin));
           }
       }
       System.out.println("Minimum distance "+minDistance);
       if(minDistance!=Integer.MAX_VALUE){
           int start = begin<end?begin:end;
           for(int i = start+1;i<(start+minDistance);i++){
               result.add(strArr[i]);
           }
       }
       return result;
   }
}
