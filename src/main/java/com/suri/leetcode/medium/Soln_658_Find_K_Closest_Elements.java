package com.suri.leetcode.medium;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]
https://leetcode.com/problems/find-k-closest-elements
 */

import com.suri.common.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Soln_658_Find_K_Closest_Elements {

    public static void main(String[] args) {

        int [] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 4;
        int x =3;

        System.out.println(findClosestElements(arr, k, x));

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b)
                ->{
            if(a.value != b.value){
                return a.value -b.value;

            }else{
                return a.key - b.key;
            }

        });
        for(int num:arr){
            minHeap.add(new Pair(num, Math.abs(x-num)));
        }

        List<Integer> result = new ArrayList<>();

        while(result.size()<k){
            result.add(minHeap.remove().key);
        }
        Collections.sort(result);
        return result;

    }
}
