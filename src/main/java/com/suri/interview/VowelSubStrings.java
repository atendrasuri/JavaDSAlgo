package com.suri.interview;

import java.util.HashSet;

/**

 */
public class VowelSubStrings {
    public static void main(String[] args) {

        String str1= "aaeiouxa";

        String str2= "aeioaexaaeuiou";
        printAllVowelSubString(str2);
        printAllVowelSubString(str1);


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