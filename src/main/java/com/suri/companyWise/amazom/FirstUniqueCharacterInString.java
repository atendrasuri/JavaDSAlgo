package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInString {
  public static void main(String[] args) {
    System.out.println(firstUniqChar("leetcode"));

  }
  public static int firstUniqChar(String s) {

    if(s==null || s.length()==0){
      return -1;
    }
    char[] charArr= s.toCharArray();
    int count[] = new int[26];

    for(int i=0;i<charArr.length;i++){
      count[charArr[i]-'a']++;
    }
    for (int i = 0; i < charArr.length; i++) {
      if (count[charArr[i]-'a'] == 1) return i;
    }
    return -1;

  }
}