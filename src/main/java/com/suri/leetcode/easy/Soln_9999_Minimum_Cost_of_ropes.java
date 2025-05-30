package com.suri.leetcode.easy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output:
29
Explanation:
For example if we are given 4
ropes of lengths 4, 3, 2 and 6. We can
connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Now we have three ropes of lengths 4, 6
and 5.
2) Now connect ropes of lengths 4 and 5.
Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all
ropes have connected.
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. Other ways of
connecting ropes would always have same
or more cost. For example, if we connect
4 and 6 first (we get three strings of 3,
2 and 10), then connect 10 and 3 (we get
two strings of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.
Example 2:

Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output:
62
Explanation:
First, connect ropes 4 and 2, which makes
the array {6,7,6,9}. Next, add ropes 6 and
6, which results in {12,7,9}. Then, add 7
and 9, which makes the array {12,16}. And
finally add these two which gives {28}.
Hence, the total cost is 6 + 12 + 16 +
28 = 62.
Your Task:
You don't need to read input or print anything. Your task isto complete the function minCost() which takes 2 arguments and returns the minimum cost.

Expected Time Complexity : O(nlogn)
Expected Auxilliary Space : O(n)

Constraints:
1 ≤ N ≤ 100000
1 ≤ arr[i] ≤ 106

https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 */
public class Soln_9999_Minimum_Cost_of_ropes {
    public static void main(String[] args) {

        int arr[] = {4, 3, 2, 6};

        System.out.println(minCost(arr, arr.length));

    }

    public static int  minCost(int arr[], int n)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            queue.add(arr[i]);
        }
        int result =0;

        while(queue.size()>1){
            int first = queue.remove();
            int  second = queue.remove();
            int sum = first+second;

            result+= sum;
            queue.add(sum);

        }

        return result;

    }
}
