package com.suri.datastructure.arrays.singledimension.subArray;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/02/19
 * @Description: (Overwrite)
 * Given an array of unordered positive and negative integers, find the maximum subarray sum in the array.
 * For example:
 * Array: {2, -9, 5, 1, -4, 6, 0, -7, 8}
 * Output:
 * Maximum subarray sum is 9
 * @History:
 */
public class MaxSumSubArray {

    public static void main(String[] args) {

        //int arr[]= {-2,-3,4,-1,-2,1,5,-1};
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        maxSum(arr);

    }

    public static void maxSum(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];

        if(arr[0]>0){
            dp[0]=arr[0];
        }
        else{
            dp[0]=0;
        }
        //dp[0]= arr[0];
        int end=0;
        int start=0;

        for(int i=1;i<n;i++){
            dp[i]= Math.max(dp[i-1]+arr[i], arr[i]);

            if(dp[i-1]>dp[i]){
                end=i-1;
            }
            if(dp[i]<0){
                start=i+1;
            }
        }

        int max=0;

        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max= dp[i];
            }
        }

        System.out.println(" max sum is"+ max);
        System.out.println(" start "+start+"  end "+end);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int dp[] = new int[n];
        dp[0]= nums[0];
        for(int i=1;i<n;i++){
            dp[i]= Math.max(dp[i-1]+nums[i], nums[i]);
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i]>maxSum){
                maxSum = dp[i];
            }
        }
        return maxSum;

    }
}