package com.suri.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/majority-element
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



 Example 1:

 Input: nums = [3,2,3]
 Output: 3
 Example 2:

 Input: nums = [2,2,1,1,1,2,2]
 Output: 2



 */

public class Soln_169_Majority_Element {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));

        System.out.println(majorityElement1(nums));
    }
    public static int majorityElement(int[] nums) {


        int count =0;
        int candidate =0;


        for(int i=0;i<nums.length;i++){

            if(count==0){
                candidate = nums[i];
                count++;
            }else{

                if(candidate==nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        if(count==0){
            return -1;
        }
        count=0;

        for(int i=0;i<nums.length;i++){

            if(candidate==nums[i]){
                count++;

            }
        }

        return count>nums.length/2?candidate:-1;

    }



    public  static int majorityElement1(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }

        return majorityEntry.getKey();
    }

    private static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }
}
