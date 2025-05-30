package com.suri.leetcode.hard;

import java.util.Arrays;

/**

 There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 Return the minimum number of candies you need to have to distribute the candies to the children.



 Example 1:

 Input: ratings = [1,0,2]
 Output: 5
 Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 Example 2:

 Input: ratings = [1,2,2]
 Output: 4
 Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 The third child gets 1 candy because it satisfies the above two conditions.
 https://leetcode.com/problems/candy/description
 */
public class Soln_135_Candy {

    public static void main(String[] args) {

        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {

        int sum =0;
        int[] left2right = new int[ratings.length];
        int [] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        for(int i=1;i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                left2right[i]= left2right[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                right2left[i]= right2left[i+1]+1;
            }
        }

        for(int i=0; i<ratings.length; i++){
            sum+= Math.max(left2right[i], right2left[i]);
        }
        return sum;

    }
}
