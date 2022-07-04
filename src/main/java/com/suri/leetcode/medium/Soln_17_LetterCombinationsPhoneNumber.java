package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input number: 234
Output:
adg adh adi aeg aeh aei afg afh
afi bdg bdh bdi beg beh bei bfg
bfh bfi cdg cdh cdi ceg ceh cei
cfg cfh cfi
Explanation: All possible words which can be
formed are (Alphabetical order):
adg adh adi aeg aeh aei afg afh
afi bdg bdh bdi beg beh bei bfg
bfh bfi cdg cdh cdi ceg ceh cei
cfg cfh cfi
If 2 is pressed then the alphabet
can be a, b, c,
Similarly, for 3, it can be
d, e, f, and for 4 can be g, h, i.

Input number: 5
Output: j k l
Explanation: All possible words which can be
formed are (Alphabetical order):
j, k, l, only these three alphabets
can be written with j, k, l.
Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
Approach: It can be observed that each digit can represent 3 to 4 different alphabets (apart from 0 and 1). So the idea is to form a recursive function. Then map the number with its string of probable alphabets, i.e 2 with “abc”, 3 with “def” etc. Now the recursive function will try all the alphabets, mapped to the current digit in alphabetic order, and again call the recursive function for the next digit and will pass on the current output string.

Example:

If the number is 23,

Then for 2, the alphabets are a, b, c
So 3 recursive function will be called
with output string as a, b, c respectively
and for 3 there are 3 alphabets d, e, f
So, the output will be ad, ae and af for
the recursive function with output string.
Similarly, for b and c, the output will be:
bd, be, bf and cd, ce, cf respectively.


https://www.geeksforgeeks.org/find-possible-words-phone-digits/
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 */
public class Soln_17_LetterCombinationsPhoneNumber {
    public static void main(String[] args) {

        letterCombinations("23");
    }

    public static void letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        String[] keyMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findCombinations(keyMap, digits, digits.length(), 0, "", results);
       // results = findCombinations1(keyMap, digits);
        System.out.println(results);
    }

    public static void findCombinations(String[] keyMap, String digits, int len, int index, String result, List<String> results) {
        if (index == len) {
            results.add(result);
            //System.out.println(result);
            return;
        }
        int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String str = keyMap[digit];
        for (int i = 0; i < str.length(); i++) {
            findCombinations(keyMap, digits, len, index + 1, result + str.charAt(i), results);
        }
    }


    public static List<String> findCombinations1(String[] keyMap, String digits) {
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        while (result.peek().length() != digits.length()) {
            String remove = result.remove();
            String map = keyMap[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                result.add(remove + c);
            }
        }
        return result;

    }
}
