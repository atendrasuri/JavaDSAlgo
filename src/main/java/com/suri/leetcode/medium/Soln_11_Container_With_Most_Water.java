package com.suri.leetcode.medium;
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
https://leetcode.com/problems/container-with-most-water/description/
 */

public class Soln_11_Container_With_Most_Water {
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height) {


        int l =0;
        int h = height.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(l<=h){

            int min = Math.min(height[l], height[h]);
            maxArea = Math.max(maxArea, (h-l)*min);

            if(height[l]<height[h]){
                l = l+1;
            }else{
                h = h-1;
            }

        }
        return maxArea;

    }
}
