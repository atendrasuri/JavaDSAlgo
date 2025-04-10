package com.suri.leetcode.medium;

/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.



Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
https://leetcode.com/problems/string-compression/description
 */
public class Soln_443_String_Compression {
    public static void main(String[] args) {

        String str = "abbbbbbbbbbbb";

        System.out.println(compress(str.toCharArray()));

    }

    public static int compress(char[] chars) {
        int i=0;
        int res =0;

        while(i<chars.length){

            int groupLength=1;

            while(i+groupLength <chars.length && chars[i+groupLength]==chars[i] ){
                groupLength++;
            }

            chars[res++]= chars[i];

            if(groupLength>1){
                for(char ch : Integer.toString(groupLength).toCharArray()){
                    chars[res++]= ch;
                }
            }
            i = i+groupLength;
        }
        // System.out.println(new String(chars));
        return res;
    }

    // if we need to return resultant String
    public static String compression(String str){
        if(str.isEmpty()){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            int cnt =1;
            char ch = str.charAt(i);
            while(i+1< str.length() && ch == str.charAt(i+1)){
                cnt++;
                i++;
            }
            result.append(ch);
            if(cnt>1){
                result.append(cnt);
            }
        }
        return result.toString();
    }

    // if we need to return resultant String
    public static String compressionSinglePass(String str){
        StringBuilder result = new StringBuilder();
        int count =1;
        for(int i=1; i<str.length(); i++){

            if(str.charAt(i-1)== str.charAt(i)){
                count++;
            }else{
                result.append(str.charAt(i-1));
                if(count>1){
                    result.append(count);
                }
                count=1;
            }
        }
        result.append(str.charAt(str.length()-1));
        if(count>1){
            result.append(count);
        }
        return result.toString();
    }
}
