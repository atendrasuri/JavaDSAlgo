package com.suri.companyWise.google;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
https://leetcode.com/problems/container-with-most-water/
 */
public class Soln_11_Container_With_Most_Water {
    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {


        int maxArea =0;

        int l =0;
        int r = height.length-1;

        while(l<r){


            maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));

            if(height[l]<height[r]){
                l= l+1;
            }else{
                r= r-1;
            }
        }
        return maxArea;

    }
}
