package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

You are not allowed to solve the problem using any serialize methods (such as eval).



Example 1:

Input: dummy_input = ["Hello","World"]
Output: ["Hello","World"]
Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);
Example 2:

Input: dummy_input = [""]
Output: [""]
https://leetcode.com/problems/encode-and-decode-strings/description/
 */
public class Soln_271_Encode_and_Decode_Strings {
    public static void main(String[] args) {
        String str = encode(Arrays.asList("Hello","World"));
        List<String> result = decode(str);
        System.out.println(result);
    }


    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str:strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i=0;
        int j=0;

        while(i<s.length()){

            j=i;

            while(s.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(s.substring(i,j));
            i= j+1;
            j = i+length;
            result.add(s.substring(i, j));
            i=j;
        }
        return result;


    }
}
