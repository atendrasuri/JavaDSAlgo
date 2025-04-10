package com.suri.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

 Letters are case sensitive, for example, "Aa" is not considered a palindrome.



 Example 1:

 Input: s = "abccccdd"
 Output: 7
 Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 Example 2:

 Input: s = "a"
 Output: 1
 Explanation: The longest palindrome that can be built is "a", whose length is 1.

 https://leetcode.com/problems/longest-palindrome
 */
public class Soln_409_Longest_Palindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int result =0;
        for(char c : s.toCharArray()){
            // If set contains the character, match found
            if(characterSet.contains(c)){
                characterSet.remove(c);
                // add the two occurrences to our palindrome
                result+=2;
            }else{
                // add the character to the set
                characterSet.add(c);
            }
        }

        // if any character remains, we have at least one unmatched
        // character to make the center of an odd length palindrome.

        if(!characterSet.isEmpty()){
            result++;
        }

        return result;

    }
}

/*

Intuition
We can also create the longest palindrome by simulating the matching process and counting the number of characters that we can match.

Let's loop over the string s and track all the characters encountered at each step. For each character, we check if it matches any previously seen character. If it does, we add these two characters to our palindrome and remove the matched character from our tracking collection. If there are unmatched characters remaining at the end, we can use any one as the middle character.

We can use a hash set to track and count our letter pairings as we loop through the string.

Hash sets are an efficient way to store and repeatedly query elements. A hash set is a data structure that stores unique elements, providing efficient insertions, deletions, and lookups. It is implemented using a hash table, which ensures that operations average O(1) time complexity. For more detailed information on hash sets and their applications, check out LeetCode's Hash Set Explore Card.

As we loop through the string s, we store each character in a hash set. If we encounter a character that matches a letter already in the set, we know we can pair it. We remove that letter from the set and count these two letters as part of our palindrome.



Algorithm
Initialize a set characterSet to store a running collection of characters.
Initialize a variable res to store our required answer.
Loop over each character c of the string s:
If characterSet already contains c, remove c from the set and add 2 to res.
Else, add c to characterSet.
If characterSet is not empty, increment res.
Return res, which holds the length of the longest palindrome.
 */
