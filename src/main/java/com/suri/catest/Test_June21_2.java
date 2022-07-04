package com.suri.catest;

import java.util.Arrays;

public class Test_June21_2 {
    public static void main(String[] args) {

        int arr[] = {0, 1, 2, 0, 1, 2, 0, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int arr[]){
        int i =0;
        int k = arr.length-1;
        int j =0;
        while(i<=k){
            int temp;
            if(arr[i]==0){
               temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
            else if(arr[i]==1){
                i++;
            } else if(arr[i]==2){
                temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
        }
    }
}
