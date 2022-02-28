package com.suri.leetcode.easy;

public class Test {

    public static void main(String[] args) {

        String originalStr ="Hello How Are You";

        String words[] = originalStr.split("\\s");
        String reversedString = "";

        //Reverse each word's position
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1)
                reversedString = words[i] + reversedString;
            else
                reversedString = " " + words[i] + reversedString;
        }

        // Displaying the string after reverse
        System.out.print("Reversed string : " + reversedString);
    }
}
