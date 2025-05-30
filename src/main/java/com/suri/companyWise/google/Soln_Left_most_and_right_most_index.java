package com.suri.companyWise.google;

import com.suri.common.Pair;

/*
Given a sorted array with possibly duplicate elements. The task is to find indexes of first and last occurrences of an element X in the given array.

Note: If the element is not present in the array return {-1,-1} as pair.



Example 1:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
X = 5
Output:
2 5
Explanation:
Index of first occurrence of 5 is 2
and index of last occurrence of 5 is 5.
Example 2:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 7, 123, 125}
X = 7
Output:
6 6


Your Task:
You don't need to read input or print anything. Your task is to complete the function indexes() which takes the array v[] and an integer X as inputs and returns  the first and last occurrence of the element X. If the element is not present in the array return {-1,-1} as pair.

Can you solve the problem in expected time complexity?


Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ v[i], X ≤ 1018
https://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/1?page=4&company[]=Google&sortBy=submissions
 */
public class Soln_Left_most_and_right_most_index {
    public static void main(String[] args) {

    }

    public Pair indexes(long v[], long x)
    {




        int low = 0;
        int high = v.length-1;

        int left =-1;
        while(low<=high){

            int mid = (low+high)/2;

            if(v[mid]==x){

                left = mid;
                high = mid-1;

            }else if(x>v[mid]){
                low = mid+1;

            }else{
                high = mid-1;
            }



        }


        low=0;
        high =  v.length-1;
        int right =-1;
        while(low<=high){

            int mid = (low+high)/2;

            if(v[mid]==x){

                right = mid;
                low = mid+1;

            }else if(x>v[mid]){
                low = mid+1;

            }else{
                high = mid-1;
            }



        }

        Pair p =  new Pair(left, right);

        return p;

    }
}
