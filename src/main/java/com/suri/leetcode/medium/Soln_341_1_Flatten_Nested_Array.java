package com.suri.leetcode.medium;

/*
https://leetcode.com/problems/flatten-nested-list-iterator/description/
You are given a nested Array of integers nestedArray.
Each element is either an integer or an Array whose elements may also be integers or other Arrays.
Implement to flatten it.
Input: {1, 2, new Object[]{3, 4, new Object[]{5, 6}}, 7, 8};
Output : [1, 2, 3, 4, 5, 6, 7, 8]

Input: { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 }
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */

import java.util.ArrayList;
import java.util.List;

public class Soln_341_1_Flatten_Nested_Array {

    public static void main(String[] args) {
        Object[] objects = {1, 2, new Object[]{3, 4, new Object[]{5, 6}}, 7, 8};
        List<Object> result = new ArrayList<>();
        flatten(objects, result);
        System.out.println(result);

        Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
        result = new ArrayList<>();
        flatten(array, result);
        System.out.println(result);
    }

    public static void flatten(Object[] objects, List<Object> result) {
        for (Object object : objects) {
            if (object instanceof Object[]) {
                flatten((Object[]) object, result);
            } else {
                result.add(object);
            }
        }
    }
}
