package com.suri.GSCoderpad;/*
==  Instructions ==
**  The below pattern of numbers are called Pascals Triangle.
**
**  Pascals Triangle exhibits the following behaviour:
**
**  The first and last numbers of each row in the triangle are 1
**  Each number in the triangle is the sum of the two numbers above it.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Please Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(1,2) should return 2
**
*/

/*import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.Assert;*/

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PascalTriangle {

   public void doTestsPass(){
     System.out.println(PascalTriangle.pascal(0,0) ==  1);
     System.out.println(PascalTriangle.pascal(1,2) ==  2);
     System.out.println(PascalTriangle.pascal(5,6) ==  6);
  }

  public static int pascal( int col, int row ){

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<>(Arrays.asList(1)));
    for (int i = 1; i <= row; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> preList = map.get(i - 1);
      for (int k = 0; k < preList.size() - 1; k++) {
        int sum = preList.get(k) + preList.get(k + 1);
        list.add(sum);
      }
      list.add(0, 1);
      list.add(i, 1);
      map.put(i, list);
    }
    return (map.get(row).get(col));

  }

  public static void main(String[] args) {
    PascalTriangle obj = new PascalTriangle();
    obj.doTestsPass();
  }
}