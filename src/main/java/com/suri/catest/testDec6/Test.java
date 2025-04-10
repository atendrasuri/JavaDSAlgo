package com.suri.catest.testDec6;



import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        String str = "Hello How are you";
       // System.out.println(getFirstNonRepeatingChar(str));

        Character res = str.chars().mapToObj(c -> (char) c).filter(c -> str.indexOf(c) == str.lastIndexOf(c)).findFirst().get();
        System.out.println(res);

        //str.chars().forEach(c -> System.out.println(getFirstNonRepeatingChar(str)));

    }


    public static char getFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (isAlphaNumeric(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
               }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '0';

    }

    private static boolean isAlphaNumeric(char ch){
        return (ch>='A' && ch<='Z') ||(ch>='a' && ch<='z') || (ch>='0' && ch<='9');
    }
}
