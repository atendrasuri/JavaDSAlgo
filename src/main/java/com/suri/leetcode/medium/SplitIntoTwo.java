package com.suri.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-experience/1316685/amazon-oa-sde1-new-questions
 Given an array of integers, determine the number of ways the entire array be split into two non-empty subarrays, left and right, such that the sum of elements in the left subarray is greater than the sum of elements in the right subarray.

 Example

 arr =  [10, 4, -8, 7]

 There are three ways to split it into two non-empty subarrays:

 [10] and [4, -8, 7], left sum = 10, right sum = 3


 [10, 4] and [-8, 7], left sum = 10 + 4 = 14, right sum = -8 + 7 = -1


 [10, 4, -8] and [7], left sum = 6, right sum = 7

 The first two satisfy the condition that left sum > right sum, so the return value should be 2.
 */

public class SplitIntoTwo {
    public static void main(String[] args) {
        System.out.println(splitIntoTwo(Arrays.asList(10, 4, -8, 7)));

    }

    public static int splitIntoTwo(List<Integer> arr){

        if(arr.isEmpty()){
            return 0;
        }
        int leftSum =0;
        int rightSum =0;
        int count =0;
        for(int a:arr){
            leftSum+= a;
        }
        for(int i = arr.size()-1; i>=0;i--){
            rightSum+= arr.get(i);
            leftSum-= arr.get(i);
            if(leftSum>rightSum &&( leftSum!=0 && rightSum!=0)){
                count++;
            }
        }
        return count;
    }
}
