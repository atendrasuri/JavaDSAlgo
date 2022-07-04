package com.suri.catest;
/*
Find Me Out

For a given number N (0 < N <= 100), little Johnny wants to find out the minimum positive integer X divisible by N, where the sum of digits of X is equal to N, and X is not equal to N.

Note: If such a number X does not exist, then output should be -1.

Input Specification:
input1: An integer N


Output Specification:
Return the minimum positive integer X


Example 1:
input1: 9


Output: 18


 */

import java.io.Serializable;

public class TestMay30 {
    public static void main(String[] args) {
        MySingleton mySingleton =   MySingleton.getInstance();
        int n =9;
        System.out.println(mySingleton.findMeOut(n));
    }
}


class MySingleton implements Serializable, Cloneable {
    private static MySingleton mySingleton;

    private MySingleton(){
    }

    public static MySingleton getInstance(){
        if(mySingleton==null){
            synchronized (MySingleton.class){
                if(mySingleton==null){
                    mySingleton = new MySingleton();
                }
            }
        }
       return  mySingleton;
    }
    public MySingleton readResolve(){
        return mySingleton;
    }

    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Can't clone");
    }
    public int findMeOut(int n){
        int result = -1;
        int x =1;
        while(x<=Integer.MAX_VALUE){
            int sumOfDigit =0;
            int num = x;
            while(num>0){
                int r = num%10;
                sumOfDigit+= r;
                num = num/10;
            }
            if(x!=n && sumOfDigit==n && x%n==0){
                return x;
            }else{
                x = x+n;
            }
        }
        return result;
    }

}


