package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/02/19
 * @Description: (Overwrite)
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * Example:-
 * Input arr[]= {9,1,4,0,2,8,6,3,5}
 * Output:- 27 units
 *
 * ref:- https://leetcode.com/problems/trapping-rain-water/
 */
public class TrapRainWater {

    public static void main(String[] args) {

        int towers[]= {9,1,4,0,2,8,6,3,5};

        System.out.println(" Maximum water that can be accumulated is "+trapRainWater(towers));

    }


    public static int trapRainWater(int height[]) {

        int n = height.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0]= height[0];

        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[n-1]= height[n-1];

        for(int i=n-2;i>=0;i--){
            right[i]= Math.max(right[i+1], height[i]);
        }

        int total_water =0;


        for(int i=0;i<n;i++){

            total_water+= Math.min(left[i], right[i])-height[i];
        }

        return total_water;
    }
}