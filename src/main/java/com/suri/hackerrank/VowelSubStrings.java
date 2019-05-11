package com.suri.hackerrank;

import java.util.HashSet;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/05/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class VowelSubStrings {
    public static void main(String[] args) {

        String str1= "aaeiouxa";

        String str2= "aeioaexaaeuiou";
//        printAllVowelSubString(str2);
//        printAllVowelSubString(str1);

        String y="";
        y.toUpperCase();
        System.out.println(y);
        say(y.toUpperCase());

    }



    public static void say(String y){


        System.out.println(y);
    }
    public static boolean isVowel(char c){

        return c=='a' || c=='e'||c=='i'||c=='o'||c=='u';
    }

    public static void printAllVowelSubString(final String str){
        if(str.length()==0){
            return;
        }

        HashSet<Character> subString= new HashSet<>();

        int n= str.length();
        int cnt=0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isVowel(str.charAt(j)) == false)
                    break;
                subString.add(str.charAt(j));

                if (subString.size() == 5) {
                    cnt++;
                    //System.out.println(str.substring(i, j + 1) + " ");
                }

            }
            subString.clear();
        }
        System.out.println(cnt);
    }
}