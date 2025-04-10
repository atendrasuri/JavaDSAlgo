package com.suri.leetcode.medium;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
https://leetcode.com/problems/powx-n

 */
public class Soln_50_Pow_x_n {
    public static void main(String[] args) {
        System.out.println(myPowIterative(2, 4));
        System.out.println(myPow_recursive(2, 3));

    }

    public  static double myPowIterative(double x, long n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            x= 1.0/x;
            n = -1*n;
        }
        double result =1;
        while(n!=0){
            if(n%2==1){
                result = result*x;
            }
            x= x*x;
            n= n/2;
        }
        return result;
    }




    public static double myPow_recursive(double x, long n) {

        if(n==0){
            return 1;
        }

        if(n<0){

            return 1.0/myPow_recursive(x,  -1 * n);
        }

        if(n%2 ==1){

            return x*myPow_recursive(x*x, (n-1)/2);
        }else{
            return myPow_recursive(x*x, n/2);
        }


    }

}
