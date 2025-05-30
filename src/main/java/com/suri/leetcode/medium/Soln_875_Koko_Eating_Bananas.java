package com.suri.leetcode.medium;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
https://leetcode.com/problems/koko-eating-bananas/description/

 */

import java.util.Arrays;

public class Soln_875_Koko_Eating_Bananas {
    public static void main(String[] args) {
        int piles[] = {3,6,7,11}, h = 8;
        System.out.println(minEatingSpeed(piles, h));

    }
    public static int minEatingSpeed(int[] piles, int h) {

        int l =0;
        int r= Arrays.stream(piles).max().getAsInt();
        int speed = Integer.MAX_VALUE;

        while(l<=r){
            int sp = (l+r)/2;
            if(isPossible(piles, sp, h)){
                speed = sp;
                r = sp-1;
            }else{
                l = sp+1;
            }
        }
        return speed;

    }

    public static boolean isPossible(int piles[], int sp, int h){
        int total_time =0;

        for(int pile:piles){
            total_time+= Math.ceil((double)pile/sp);
        }
        return total_time<=h;
    }
}
