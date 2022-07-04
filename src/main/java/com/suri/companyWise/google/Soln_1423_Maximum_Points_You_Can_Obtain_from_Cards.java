package com.suri.companyWise.google;
/*
https://leetcode.com/discuss/interview-question/701938/google-max-sum-of-k-elements
 */
public class Soln_1423_Maximum_Points_You_Can_Obtain_from_Cards {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,1};
        int k =3;

        System.out.println(maxScore(arr, k));

    }

    public  static int maxScore(int[] arr, int k) {
        int sum = 0;
        int masXum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        masXum = sum;
        int j = arr.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            // add from right end but remove from left-right
            sum = sum + arr[j] - arr[i];
            masXum = Math.max(sum, masXum);
            j--;
        }

        return masXum;
    }
}
