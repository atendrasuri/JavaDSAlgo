package com.suri.catest;

/*

given a positive integer n, 3 operations subtract by 1, divide by 2 if divisible, divide by 3 if divisible
find min steps required to reduce n to 1


n =4

4/2 =2
2/2 =1

min (4, 2) = 2


5

5 -1 = 4

4/2 = 2
2/2 = 1
min(3, 5) = 3


10-1 = 9
9/3 =3
3/3 = 1




23

23-1 = 22

22/2 =11






 */

public class TestApril22 {
    public static void main(String[] args) {

        System.out.println(minSteps(10));

    }


    public static int minSteps(int n){
        if(n==1){
            return 0;
        }
        if(n%3==0){
             return 1+ Math.min(minSteps(n / 3), minSteps(n - 1 ));
         }else if(n%2==0){
             return 1+ Math.min(minSteps(n / 2), minSteps(n - 1 ));
         }else{
             return 1+ minSteps(n - 1 );
         }

    }



}
