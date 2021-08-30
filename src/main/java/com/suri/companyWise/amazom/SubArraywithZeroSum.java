package com.suri.companyWise.amazom;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SubArraywithZeroSum {

    public static void main(String[] args) {

        int arr[] = {1, 4, -2, -2, 5, -4, 3};
        subArraywithZeroSum(arr);

    }

    public static void subArraywithZeroSum(int arr[]){


        int n = arr.length;


        Map<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int start=0;
        int end=0;
        boolean flag=false;

        for(int i=0;i<n;i++){
            sum+= arr[i];
            if(arr[i]==0|| sum==0 || map.get(sum)!=null){
                start=map.get(sum)+1;
                end =i;
                flag=true;
                break;
            }

            map.put(sum,i);

        }


        if(flag){
            System.out.println(" zero sum present  start "+start+" end  "+end);
        }

    }
}