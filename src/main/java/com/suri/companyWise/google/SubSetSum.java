package com.suri.companyWise.google;

public class SubSetSum {
    public static void main(String[] args) {

        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum =9;
        System.out.println(isSubSetSum(arr, sum));

    }




    static boolean  isSubSetSum(int arr[], int sum){


        boolean dp[][] = new boolean[arr.length+1][sum+1];


        for(int i=0;i< dp.length;i++){

            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j == 0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] =false;
                }else if(j==0){
                    dp[i][j] = true;
                }else{
                    if(dp[i-1][j]==true){
                        dp[i][j] = true;
                    }else {
                        int val = arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
     return dp[arr.length][sum];
    }
}
