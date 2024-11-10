package com.suri.companyWise.google;

/*
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.



Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= m <= min(50, nums.length)

https://leetcode.com/problems/split-array-largest-sum/
 */
public class Soln_410_Split_Array_Largest_Sum {
    public static void main(String[] args) {


      int arr[] =  {7,2,5,10,8};
       int m = 2;

        System.out.println(splitArray(arr, m));

    }

    public static int splitArray(int[] nums, int m) {



        int low=0;
        int high =0;


        for(int i=0;i<nums.length;i++){

            low = Math.max(low, nums[i]);
            high+= nums[i];

        }

        int ans =0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums, mid, m)){
                ans =mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }





    public static boolean isPossible(int arr[], int mid, int m){


        int cnt =1;
        int sum =0;
        for(int i=0;i<arr.length;i++){

            sum += arr[i];

            if(sum>mid){
                cnt++;
                sum =arr[i];
            }

        }
        return cnt<=m;

    }
}
