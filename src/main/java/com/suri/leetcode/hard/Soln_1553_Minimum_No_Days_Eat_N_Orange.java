package com.suri.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:

Eat one orange.
If the number of remaining oranges n is divisible by 2 then you can eat n / 2 oranges.
If the number of remaining oranges n is divisible by 3 then you can eat 2 * (n / 3) oranges.
You can only choose one of the actions per day.

Given the integer n, return the minimum number of days to eat n oranges.



Example 1:

Input: n = 10
Output: 4
Explanation: You have 10 oranges.
Day 1: Eat 1 orange,  10 - 1 = 9.
Day 2: Eat 6 oranges, 9 - 2*(9/3) = 9 - 6 = 3. (Since 9 is divisible by 3)
Day 3: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1.
Day 4: Eat the last orange  1 - 1  = 0.
You need at least 4 days to eat the 10 oranges.
Example 2:

Input: n = 6
Output: 3
Explanation: You have 6 oranges.
Day 1: Eat 3 oranges, 6 - 6/2 = 6 - 3 = 3. (Since 6 is divisible by 2).
Day 2: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. (Since 3 is divisible by 3)
Day 3: Eat the last orange  1 - 1  = 0.
You need at least 3 days to eat the 6 oranges.


Constraints:

1 <= n <= 2 * 109

https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/

 */
public class Soln_1553_Minimum_No_Days_Eat_N_Orange {
    public static void main(String[] args) {
        System.out.println(minDays(10));
        System.out.println(minDays(6));
        System.out.println(minDays(5));
    }
    public static int minDays(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        int temp =0;

        queue.add(n);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>=1){
                int num = queue.remove();
                if(num==0)return temp;
                if(num%2==0 && !set.contains(num/2)){
                    queue.add(num/2) ;
                    set.add(num/2);
                }
                if(num%3==0 && !set.contains(num/3)){
                    queue.add(num/3) ;
                    set.add(num/3);
                }
                if( !set.contains(num-1)){
                    queue.add(num-1) ;
                    set.add(num-1);
                }
                size--;
            }
            temp+=1;
        }

        return temp;

    }
}