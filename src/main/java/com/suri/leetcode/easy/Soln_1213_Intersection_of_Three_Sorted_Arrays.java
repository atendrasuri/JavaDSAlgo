package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.



Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
Example 2:

Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []


Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000

 */
public class Soln_1213_Intersection_of_Three_Sorted_Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2= {1,2,5,7,9};
        int [] arr3 = {1,3,4,5,8};

        System.out.println(arraysIntersection(arr1, arr2, arr3));


    }
    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int x =0, y=0, z=0;
        List<Integer> result = new ArrayList<>();
        while(x<arr1.length && y<arr2.length && z<arr3.length){

            if(arr1[x]==arr2[y] && arr2[y]==arr3[z]){
                result.add(arr1[x]);
                x++;
                y++;
                z++;
            }else{

                if(arr1[x]<arr2[y]){
                    x++;
                }
                else if(arr2[y]<arr3[z]){
                    y++;
                }else{
                    z++;
                }
            }
        }
        return result;

    }

}
