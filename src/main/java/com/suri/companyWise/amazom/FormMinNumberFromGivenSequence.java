package com.suri.companyWise.amazom;

import java.util.Stack;

/**
 * Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern.
 * Digits from 1-9 and digits can’t repeat.
 *
 * Examples:
 *
 *    Input: D        Output: 21
 *    Input: I        Output: 12
 *    Input: DD       Output: 321
 *    Input: II       Output: 123
 *    Input: DIDI     Output: 21435
 *    Input: IIDDD    Output: 126543
 *    Input: DDIDDIID Output: 321654798
 *
 *    best explanation:- https://www.youtube.com/watch?v=KMdGBk2VhYk
 */
public class FormMinNumberFromGivenSequence {
    public static void main(String[] args) {
        /*printMinNumberForPattern("IDID");
        printMinNumberForPattern("I");
        printMinNumberForPattern("DD");
        printMinNumberForPattern("II");
        printMinNumberForPattern("DIDI");
        printMinNumberForPattern("IIDDD");
        printMinNumberForPattern("DDIDDIID");*/
        printMinNumberForPattern("DDIDDIIDIII");
    }

    public static void printMinNumberForPattern(String seq){

        String result="";

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<=seq.length();i++){

            stack.push(i+1);

            if(i==seq.length() || seq.charAt(i)=='I'){

                while(!stack.isEmpty()){
                    result=result+stack.pop();
                }
            }
        }

        System.out.println(" "+result);
    }


}