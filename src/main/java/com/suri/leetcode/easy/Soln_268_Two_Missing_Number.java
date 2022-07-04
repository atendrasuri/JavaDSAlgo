package com.suri.leetcode.easy;

/*
 * Algorithm
 * * 1) Suppose we have numbers 1 to n and an array of numbers from 1 to n. Lets suppose two numbers are missing.
 * * 2) Find xor of 1 to n and all elements of array.
 *  * 3) XOR will contain the XOR value of two missing numbers.
 * * 4) Examin any set bit(bit with value 1) in xor. This bit value is 1 because from the missing numbers one number
 * * has value 0 and the other has value 1 at this bit location.
 * * For our example lets consider the rightmost set bit. Let the location of rightmost set bit in xor be l.
 * * 5) Now we can divide our numbers from 1 and n into two sets. First set will have all the numbers having 1 set
 * * bit location l Lets call this nset1.
 *  * Second set will have all numbers having 0 at bit location l. Lets call this nset0.
 * * 6) Similarly we can divide our arr into two groups. First group will have all the elements having 1 at location
 * * l. Lets call this arrset1. The other group will have all
 * * the numbers having 0 at location l. Lets call this arrset0.
 * * 7) Find the rightmost set bit in xor. Suppose we want to find right most set bit in number n. We know n&~n is
 * * zero.n-1 will flip the value of rightmost set bit in n.
 * * ~(n-1) will flip the value of rightmost set bit twice, making it to its original value as that of n. When we
 * * do n&~(n-1) we get the number representing rightmost set
 * * bit in n. This we can find the rightmost set bit in xor and call it set_bit.
 * * 8) To achieve step 5 we iterate over all the numbers from 1 to n and check if rightmost bit is set in number
 * * or not. This can be done by performing & operation of number
 * * with set_bit. If value of & operation is greater than 0 this means rightmost bit is set, else it is not set.
 * * We can store xor values of nset1 in x and nset0 in y.
 * * 9) We can repeat above step 8 for step 6 and perform xor of x with arrset1, and that of y with arrset0.
 * * 10) We get the result in x and y.

 */
public class Soln_268_Two_Missing_Number {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 5, 6};
        int[] arr = {1, 2, 5, 6};
        int len = 2 + arr.length;
        findMissing(arr, len);
    }

    private static void findMissing(int[] arr, int n) {
        int x1 = arr[0];
        int x2 = 1;
        for(int i = 1; i < n-2; i++){
            x1 = x1^arr[i];
        }
        for(int i = 2; i <= n; i++){
            x2 = x2^i;
        }
        int x3 = x1^x2;
        System.out.println(x3);
        System.out.println(x3-1);
        System.out.println("~(x3-1)=" + ~(x3-1));
        int setRightBit = x3&~(x3-1);
        System.out.println("setRightBit " + setRightBit );
        int x = 0, y = 0;
        for(int i = 0; i < n-2; i++){
            if((setRightBit & arr[i]) > 0){
                x = x ^ arr[i];
            } else {
                y = y ^ arr[i];
            }
        }
        for(int i = 1;i <= n; i++){
            if((setRightBit & i) > 0){
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }
        System.out.println("Two Missing Numbers are "+x+" and "+y);

    }
}
