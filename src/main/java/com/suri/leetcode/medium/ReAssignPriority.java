package com.suri.leetcode.medium;

/**
 * https://leetcode.com/discuss/interview-experience/1316685/amazon-oa-sde1-new-questions
 You are given a List of Integers which is a list of priorities. A priority can be a number from 1-99. Without changing the order of the array, minimize the priority as much as possible without changing the order.
 Example

 arr = [1, 4, 8, 4]

 ->

 [1, 2, 3, 2]
 */

import java.util.*;

public class ReAssignPriority {
    public static void main(String[] args) {
        System.out.println(reAssignPriority(Arrays.asList(1, 4, 8, 4)));
        System.out.println(reAssignPriority_1(Arrays.asList(1, 4, 8, 4)));
    }

    public static List<Integer> reAssignPriority(List<Integer> priorities) {

        int counts[] = new int[100];
        List<Integer> result = new ArrayList<>();
        for (Integer priority : priorities) {
            counts[priority] = counts[priority] + 1;
        }
        int reducedPriority = 1;
        for (int index = 0; index < counts.length; index++) {
            if (counts[index] > 0) {
                counts[index] = reducedPriority++;
            }
        }
        for (int index = 0; index < priorities.size(); index++) {
            result.add(counts[priorities.get(index)]);
        }
        return result;
    }

    // second approach

    public static List<Integer> reAssignPriority_1(List<Integer> priorities) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        for (Integer priority : priorities) {
            set.add(priority);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int reducedPriority = 1;
        for (Integer t : set) {
            map.put(t, reducedPriority);
            reducedPriority++;
        }
        for (int priority : priorities) {
            if (map.containsKey(priority)) {
                result.add(map.get(priority));
            }
        }
        return result;
    }
}
