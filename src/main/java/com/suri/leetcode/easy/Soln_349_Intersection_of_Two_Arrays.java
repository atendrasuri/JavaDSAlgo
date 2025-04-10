package com.suri.leetcode.easy;

/*
Given two integer arrays nums1 and nums2, return an array of their
intersection
. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
https://leetcode.com/problems/intersection-of-two-arrays/description/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Soln_349_Intersection_of_Two_Arrays {
    public static void main(String[] args) {

        int[] nums1= {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int [] result = intersection(nums1, nums2);
        for(int num : result){
            System.out.print(" "+num);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int val:nums1){
            set.add(val);
        }

        for(int val:nums2){
            if(set.contains(val)){
                set.remove(val);
                result.add(val);
            }
        }
        int[] finalResult = new int[result.size()];
        for(int i=0;i<result.size();i++){
            finalResult[i]= result.get(i);
        }
        return finalResult;



    }
}
