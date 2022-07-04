package com.suri.catest;

import java.util.Arrays;

public class TestMay1101 {
    public static void main(String[] args) {

        //int arr1[] = {5,4,-1,7,8, -8,-5, 50};
        //System.out.println(maxSum(arr1));


        //int arr2[] = {4,5, -4,-6};

        //System.out.println(maxSum(arr2));

        int arr3[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr3));



    }

    public static int maxSum(int nums[]) {

        int startIndex =-1;
        int endIndex = -1;

        int cs = nums[0];

        int os = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (cs >= 0) {
                cs += nums[i];

            } else {
                startIndex = i;
                cs = nums[i];

            }
            if (cs > os) {
                endIndex =i;
                os = cs;
            }
        }
        System.out.println("startIndex = "+startIndex +" endIndex = "+endIndex);
        return os;
    }
}
