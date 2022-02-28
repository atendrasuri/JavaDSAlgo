package com.suri.leetcode.easy;

/**

 Distributing M items in a circle of size N starting from K-th position
 M items are to be delivered in a circle of size N. Find the position where the M-th item will be delivered if we start from a given position K. Note that items are distributed at adjacent positions starting from K.
 Examples :


 Input:
 N = 5, M = 2, K = 1
 Output:
 2
 Explanation:
 If we start from 1st position, the
 2nd item will land at the 2nd position.

 Input:
 N = 5, M = 8, K = 2
 Output:
 4
 Explanation:
 If we start from 2nd position, the
 8th item will land at the 4th position.
 */
public class Soln_Distributing_M_items_in_circle {
    public static void main(String[] args) {
        int N = 5, M = 2, K = 1;
        System.out.println(findPosition(N, M, K));
    }
    static int findPosition(int N , int M , int K) {
        int result = (K+M-1)%N;
        if(result ==0){
            return N;
        }
        return result;
    }
}
