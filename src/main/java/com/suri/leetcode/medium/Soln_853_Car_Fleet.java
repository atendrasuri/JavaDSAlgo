package com.suri.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/*
https://leetcode.com/problems/car-fleet/description/
https://neetcode.io/problems/car-fleet

here are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.



Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

Output: 3

Explanation:

The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Example 2:

Input: target = 10, position = [3], speed = [3]

Output: 1

Explanation:

There is only one car, hence there is only one fleet.
Example 3:

Input: target = 100, position = [0,2,4], speed = [4,2,1]

Output: 1

Explanation:

The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 */
public class Soln_853_Car_Fleet {
    public static void main(String[] args) {

        int position[] = {10,8,0,5,3};
        int speed [] =    {2,4,1,1,3};

        System.out.println(carFleet(12, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {

        int pair[][] = new int[position.length][2];

        for(int i=0;i<position.length;i++){

            pair[i][0] = position[i];
            pair[i][1]= speed[i];
        }

        Arrays.sort(pair, (a, b)-> b[0]-a[0]);
        Stack<Double> stack = new Stack<>();

        for(int [] p:pair){

            stack.push((double) (target-p[0])/p[1]);

            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();

    }
}
