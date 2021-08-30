package com.suri.companyWise.amazom;

import java.util.Arrays;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/04/19
 * @Description: (Overwrite)
Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)
 */
public class MinimumNumberofPlatformsRequired {

    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatFormrequired(arr, dep));

    }

    public static int  findPlatFormrequired(int arr[], int dep[]){

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=1;int j=0;
        int platFormRequired=1;
        int result=1;

        int n= arr.length;

        while(i<n && j<n){

            int a= arr[i];
            int d= dep[j];
            if(arr[i]<=dep[j]){
                platFormRequired++;
                i++;

                if(platFormRequired>result){
                    result= platFormRequired;

                }
            }
            else{
                platFormRequired--;
                j++;
            }
        }
        return result;

    }
}