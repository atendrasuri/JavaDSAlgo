package com.suri.catest;

import java.util.Arrays;
import java.util.List;

public class TestJan24_2023 {


    public static void main(String[] args) {


        String str = "abc,def,,";

        List<String> propertyNameList = Arrays.asList(str.trim().split(",", -1 ));

        System.out.println(propertyNameList);
    }
}
