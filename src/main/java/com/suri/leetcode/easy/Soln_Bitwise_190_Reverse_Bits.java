package com.suri.leetcode.easy;

/*
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.


Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

https://leetcode.com/problems/reverse-bits/description

Approach
To reverse the bits:

Initialize a result variable to 0.
Iterate 32 times (since the integer is 32 bits):
Extract the last bit of n using n & 1.
Shift the result to the left by 1 and add the extracted bit.
Shift n to the right by 1 to process the next bit.
Return the result
 */
public class Soln_Bitwise_190_Reverse_Bits {
    public static void main(String[] args) {
        int n = 001111111111;
        System.out.println(reverseBits(n));

    }
    public static int reverseBits(int n) {
        int result =0;
        for(int i=0;i<32;i++){
            int lastBit = n&1;
            result = (result<<1) | lastBit;
            n = n>>1;
        }
        return result;

    }
}
