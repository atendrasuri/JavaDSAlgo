package com.suri.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
https://leetcode.com/problems/asteroid-collision
 */
public class Soln_735_Asteroid_Collision {
    public static void main(String[] args) {

        int[] nums = {5,10,-5};

        Arrays.stream(asteroidCollision(nums)).boxed().forEach(System.out::print);

    }
    public static int[] asteroidCollision(int[] asteroids) {


        Stack<Integer> stack = new Stack<>();

        for(int asteroid: asteroids){

            boolean exploded = false;


            while(!stack.isEmpty() && asteroid<0 && stack.peek()>0){


                if(Math.abs(stack.peek())< Math.abs(asteroid)){
                    stack.pop();
                    continue;
                }else if(Math.abs(stack.peek())==Math.abs(asteroid)){
                    stack.pop();
                }

                exploded = true;
                break;
            }

            if(!exploded){
                stack.push(asteroid);
            }


        }

        int[] result = new int[stack.size()];

        int index =0;

        for(int ast:stack){
            result[index++]= ast;
        }
        return result;

    }
}
