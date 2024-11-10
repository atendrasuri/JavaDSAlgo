package com.suri.leetcode.easy;

import java.util.*;

public class TestNov25 {
    public static void main(String[] args) {

        List<String> input = Arrays.asList("abc", "bca", "TEST", "TTES", "ESTT", "TEMP", "acb");
        System.out.println(function(input));
    }
    public static List<List<String>> function(List<String> list){

        List<List<String>> result = new ArrayList<>();
        if(list==null || list.size()==0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : list) {
            char[] charArray = str.toCharArray();
            //sort the char Arrays
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }

        for(Map.Entry<String, List<String>>entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
