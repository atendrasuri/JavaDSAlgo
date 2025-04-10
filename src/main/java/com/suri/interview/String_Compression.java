package com.suri.interview;

import java.util.Stack;

/**

 Given an array of characters chars, compress it using the following algorithm:

 Begin with an empty string s. For each group of consecutive repeating characters in chars:

 If the group's length is 1, append the character to s.
 Otherwise, append the character followed by the group's length.
 Input: "abbcccde"
 Output: "ab2c3de

 */
public class String_Compression {
    public static void main(String[] args) {
        System.out.println(compression("abbcccde").equals("ab2c3de"));
        System.out.println(compressionSinglePass("abbcccde").equals("ab2c3de"));
    }

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

    public static String decompression(String str){

        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(!Character.isDigit(ch)){
                stack.push(ch);
            }else{
                 int repeat = Integer.parseInt(String.valueOf(ch));
                 char res = stack.pop();
                 for(int i= 0; i<repeat; i++){
                     result.append(res);
                 }
            }
        }
        return null;

    }


}
