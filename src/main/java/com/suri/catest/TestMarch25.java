package com.suri.catest;

import java.util.ArrayList;
import java.util.List;

public class TestMarch25 {
    public static void main(String[] args) {

        String str = "abcde";
        String result = "";
        List<String> results = new ArrayList<>();
        method1(result, str,3, results );
        System.out.println(results);
        System.out.println(results.size());

    }


    public static void method1(String result, String str, int n, List<String> results){

        if(str.length()==0){
            results.add(result);
            return;
        }
        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1, str.length());
            System.out.println("left =="+left+"  right =="+right);
            method1(result+str.charAt(i), left+right, n, results);
        }


    }


}
