package com.suri.leetcode.easy;

/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.



Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

https://leetcode.com/problems/can-place-flowers
 */
public class Soln_605_Can_Place_Flowers {

    public static void main(String[] args) {
        int nums[] = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(nums, 2));

    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {


        int length = flowerbed.length;


        for(int i=0;i<length; i++){

            // Check if the current plot is empty.
            if(flowerbed[i]==0){

                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i==0 || flowerbed[i-1]==0);
                boolean emptyRightPlot = (i==length-1 || flowerbed[i+1]==0);

                // If both plots are empty, we can plant a flower here.
                if(emptyLeftPlot && emptyRightPlot){
                    flowerbed[i]=1;
                    n--;
                    if(n==0){
                        return true;
                    }
                }
            }
        }
        return n<=0;
    }

}
