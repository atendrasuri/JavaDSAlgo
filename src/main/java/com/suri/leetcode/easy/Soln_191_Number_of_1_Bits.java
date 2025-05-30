package com.suri.leetcode.easy;

/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.


Example 1:

Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

https://leetcode.com/problems/number-of-1-bits/
https://www.youtube.com/watch?v=I475waWiTK4&ab_channel=Pepcoding

 */
public class Soln_191_Number_of_1_Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight1(11));

        System.out.println(hammingWeight(11));

    }

    public static int hammingWeight1(int n) {

        int result =0;

        while(n!=0){

            result+= (n&1)==1?1:0;
            n=n>>1;
        }
        return result;

    }
    public static int hammingWeight(int n) {

        int c =0;
        while(n!=0){
            n = n&(n-1);
            c= c+1;
        }
        return c;
    }
}
