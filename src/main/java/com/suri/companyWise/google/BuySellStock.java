package com.suri.companyWise.google;

public class BuySellStock {
    public static void main(String[] args) {

        int arr[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));

    }
    public static int maxProfit(int arr[]){
        int n = arr.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return arr[0];
        }
        int maxProfit =0;
        //7,1,5,3,6,7
        for(int i =0;i<n-1;){
            while(i<n-1 && arr[i+1]<=arr[i] ){
                i++;
            }
            int puchaseIndex =i;
            while(i<n-1 && arr[i+1]>= arr[i]){
                i++;
            }

            int saleIndex = i;
            int profix = arr[saleIndex]-arr[puchaseIndex];

            maxProfit = maxProfit+profix;

        }

        return maxProfit;
    }
}
