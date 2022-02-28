package com.suri.java.collection;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class HashMapTest implements Comparator<HashMapTest> {
  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>(20);
    String s1 = "Hello";

    map.put("Hello",10);

    System.out.println(map.size());
 String workingDir = null;
    File test = new File(workingDir);
    System.out.println(test);

  }

  @Override
  public int compare(HashMapTest o1, HashMapTest o2) {
    return 0;
  }
}