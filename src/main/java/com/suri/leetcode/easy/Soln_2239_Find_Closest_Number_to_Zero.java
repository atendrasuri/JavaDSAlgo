package com.suri.leetcode.easy;

/**

 Example 1:

 Input: nums = [-4,-2,1,4,8]
 Output: 1
 Explanation:
 The distance from -4 to 0 is |-4| = 4.
 The distance from -2 to 0 is |-2| = 2.
 The distance from 1 to 0 is |1| = 1.
 The distance from 4 to 0 is |4| = 4.
 The distance from 8 to 0 is |8| = 8.
 Thus, the closest number to 0 in the array is 1.
 Example 2:

 Input: nums = [2,-1,1]
 Output: 1
 Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 https://leetcode.com/problems/find-closest-number-to-zero
 */

public class Soln_2239_Find_Closest_Number_to_Zero {

    public static void main(String[] args) {
        int[]nums = {-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));
    }

    public static int findClosestNumber(int[] nums) {
        int positive = Integer.MAX_VALUE;
        int negative = Integer.MIN_VALUE;
        for(int num:nums){

            if(num>=0){
                positive = Math.min(positive, num);
            }else{

                negative = Math.max(negative, num);
            }
        }

        if(positive == Integer.MAX_VALUE){
            return negative;
        }

        if(negative== Integer.MIN_VALUE){
            return positive;
        }


        return positive == Math.abs(negative)? positive: (positive<Math.abs(negative))?positive:negative;

    }
}
