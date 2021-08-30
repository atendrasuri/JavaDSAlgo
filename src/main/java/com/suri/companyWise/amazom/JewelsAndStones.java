package com.suri.companyWise.amazom;

import java.util.HashSet;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {
  public static void main(String[] args) {
    String J = "aA", S = "aAAbbbb";

    System.out.println(numJewelsInStones(J, S));
  }

  public static int numJewelsInStones(String J, String S) {

    HashSet<Character> jewels = new HashSet<>();

    for (Character c : J.toCharArray()) {
      jewels.add(c);
    }

    int totalStones = 0;

    for (char c : S.toCharArray()) {
      if (jewels.contains(c)) {
        totalStones++;
      }
    }
    return totalStones;
  }
}