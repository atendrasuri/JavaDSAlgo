package com.suri.catest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJune27 {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put("one", "A");
        map.put("two", "B");
        map.put("three", "C");


        List<String> list = (List<String>)map.values();
        System.out.println(list);
    }
}
