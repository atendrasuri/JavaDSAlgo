package com.suri.catest;

public class TestJune21_1 {
    public static void main(String[] args) {
        //1-n
        int [] arr = {4, 2, 4, 5, 6, 3};

        method1(arr);

        // 4 -
        //2
        //4
        //5
        //6
        //3
       // [4, -2, -4, -5, -6, -3]

    }

    public static void method1(int arr[]){

        int n = arr.length;

        for(int i =0;i<n; i++){

            int abs_value = Math.abs(arr[i]);

            if(arr[abs_value-1]>0){
                arr[abs_value-1] = - arr[abs_value-1];
            }else{
                System.out.println("duplicate number "+abs_value);
            }
        }

        for(int i =0;i<n;i++){
            if(arr[i]>0){
                System.out.println("missing number :: "+(i+1));
            }
        }



    }
}
