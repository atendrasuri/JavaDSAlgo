package com.suri.leetcode.easy;

/*
Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
https://leetcode.com/problems/shortest-distance-to-a-character

 */

public class Spln_821_Shortest_Distance_to_a_Character {
    public static void main(String[] args) {
        System.out.println(shortestToChar("loveleetcode", 'e'));

    }
    public static int[] shortestToChar(String s, char c) {

        int[] result = new int[s.length()];
        int min = Integer.MAX_VALUE;
        int n = s.length();
        for(int i=0;i<n;i++){
            min = Integer.MAX_VALUE;
            for(int j =0;j<n;j++){
                char ch = s.charAt(j);
                if(ch==c){
                    int distance = Math.abs(i-j);
                    min = Math.min(min, distance);
                }
            }
            result[i]=min;
        }
        return result;

    }
}


