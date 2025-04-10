package com.suri.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

 https://leetcode.com/problems/k-closest-points-to-origin/description/
 */
public class Soln_973_K_Closest_Points_to_Origin {
    public static void main(String[] args) {

        int points[][] = {{1,3},{-2,2}};
        Arrays.stream(kClosest(points, 1)).forEach(x-> System.out.println(x[0]+" "+x[1]));
       // System.out.println(kClosest(points, 1));

    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> (a[0]*a[0] +a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]) );
        for(int[] point : points){
            minHeap.add(point);
        }
        int[][] result = new int[k][2];
        int index =0;
        while(index<k){
            result[index] = minHeap.remove();
            index++;
        }
        return result;

    }
}
