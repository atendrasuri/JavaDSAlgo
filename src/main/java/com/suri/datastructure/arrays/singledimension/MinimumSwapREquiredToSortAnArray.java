package com.suri.datastructure.arrays.singledimension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/03/19
 * @Description: (Overwrite)
 * 1. Given an array of n distinct elements, find the minimum number of swaps required to sort the array.
 *
 * @History:
 */
public class MinimumSwapREquiredToSortAnArray {


    public static void main(String[] args) {

        int arr[]={20,15,18,12,11,10,9};

        System.out.println("  "+minSwap(arr));

    }

    public static int minSwap(int arr[]){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            arr[i]= map.get(arr[i]);
        }



        int swap=0;

        for(int i=0;i<arr.length;i++){


            int val=arr[i];

            if(val<0){
                continue;
            }

            while(val!=i){
                int newval = arr[val];
                arr[val]=-1;
                val= newval;
                swap++;

            }

            arr[i]=-1;
        }
        return swap;
    }
}
