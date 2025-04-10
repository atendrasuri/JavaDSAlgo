package com.suri.leetcode.easy;

/*

There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.



Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
https://leetcode.com/problems/find-the-highest-altitude

 */
public class Soln_1732_Find_the_Highest_Altitude {

    public static void main(String[] args) {

        int[] gain = {0,-4,-7,-9,-10,-6,-3,-1};
        System.out.println(largestAltitude(gain));

    }

    public static int largestAltitude(int[] gain) {
        int currentAltitude =0;
        int highestAltitude =currentAltitude;
        for(int i=0;i<gain.length; i++){
            currentAltitude+= gain[i];

            highestAltitude = Math.max(highestAltitude, currentAltitude);

        }
        return highestAltitude;

    }
}

/*

Algorithm

Initialize the variable currentAltitude to 0; this is the current altitude of the biker.
Initialize the variable highestPoint to currentAltitude, as the highest altitude we have seen is 0.
Iterate over the gain in altitude in the list gain and add the current gain altitudeGain to the variable currentAltitude.
Update the variable highestPoint as necessary.
Return highestPoint.


Complexity Analysis

Here, N is the number of integers in the list gain.

Time complexity: O(N).

We iterate over every integer in the list gain only once, and hence the total time complexity is equal to O(N).

Space complexity: O(1).

We only need two variables, currentAltitude andhighestPoint; hence the space complexity is constant.

 */
