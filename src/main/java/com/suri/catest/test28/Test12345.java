package com.suri.catest.test28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test12345 {


    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
    String str = "A";

        lst.addAll( Arrays.asList(str.split(",")));

        System.out.println(lst);;


    }
}
