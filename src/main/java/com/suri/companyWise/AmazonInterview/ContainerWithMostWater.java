package com.suri.companyWise.AmazonInterview;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {
  public static void main(String[] args) {

    int height[]={1,8,6,2,5,4,8,3,7};

    System.out.println(maxArea(height));
    System.out.println(maxAreaTwoPass(height));

  }


  public static int maxArea(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int maxArea = Integer.MIN_VALUE;

    int l = 0;
    int h = height.length - 1;

    while (l < h) {

      int min = Math.min(height[l], height[h]);
      maxArea = Math.max(maxArea, min * (h - l));

      if (height[l] < height[h]) {
        l++;
      } else {
        h--;
      }
    }
    return maxArea;

  }

  public static int maxAreaTwoPass(int[] height){

    if (height.length == 0) {
      return 0;
    }
    int maxArea = Integer.MIN_VALUE;

   for(int i=0;i<height.length;i++){
     for(int j=i+1;j<height.length;j++){
       int min = Math.min(height[i],height[j]);
       maxArea = Math.max(maxArea,min*(j-1));
     }
   }



    return maxArea;
  }
}