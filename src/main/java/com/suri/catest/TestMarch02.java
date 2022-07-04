package com.suri.catest;

import java.util.*;

public class TestMarch02 {
    public static void main(String[] args) {
        System.out.println("Hello");

        int arr[] = {1,2,2,1,3,1,1,3};
        f1(arr, 4);
    }

    public static void f1(int arr[], int k){

        Map<Integer, Integer> window = new LinkedHashMap();

        for(int i=0;i<k;i++){
           // window.add(arr[i]);
        }

        for(int i=k;i< arr.length;i++){

            System.out.println(window.size());
            window.remove(0);
            for(int j=0;j<k;j++){

            }
        }

    }
}
