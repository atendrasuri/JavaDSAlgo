package com.suri.leetcode.easy;

import java.util.*;

/*
Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.



Example 1:

Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation:
The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
Example 2:

Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
Output: [[1,100],[7,100]]

https://leetcode.com/problems/high-five/description
 */
public class Soln_1086_High_Five {
    public static void main(String[] args) {

        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int [][] result = highFive(items);

        Arrays.stream(result).map(Arrays::toString).forEach(System.out::println);

    }

    public static int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>();
        int K =5;
        for(int[] item :items){
            int Id = item[0];
            int score = item[1];
            if(!map.containsKey(Id)){
                map.put(Id, new PriorityQueue<>((a, b)->b-a));
            }
            map.get(Id).add(score);
        }
        List<int[]> solution = new ArrayList<>();
        for(Map.Entry<Integer, Queue<Integer>> entry: map.entrySet()){

            int Id = entry.getKey();
            int sum=0;
            for(int i=0;i<K;i++){
                sum+= entry.getValue().poll();
            }
            solution.add(new int[]{Id, sum/K});
        }
        return solution.toArray(new int[solution.size()][]);

    }
}
