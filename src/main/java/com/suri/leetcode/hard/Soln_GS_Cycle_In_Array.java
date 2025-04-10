package com.suri.leetcode.hard;

/*
Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to. Find a cycle and return its length. No cycle is found -> -1.

int lengthOfCycle(int[] arr, int startIndex) {
	// todo
}
Examples:

lengthOfCycle([1, 0], 0); // 2
lengthOfCycle([1, 2, 0], 0); // 3
lengthOfCycle([1, 2, 3, 1], 0); // 3

https://leetcode.com/discuss/interview-question/1218147/goldman-coderpad
https://leetcode.com/discuss/interview-question/413065/goldman-sachs-cycle-in-array-trapping-rain-water
 */
public class Soln_GS_Cycle_In_Array {
    public static void main(String[] args) {
//        int[] nums1 = {1,0};
//        System.out.println(lengthOfCycle(nums1, 0));
//        int[] nums2 = {1, 2, 0};
//        System.out.println(lengthOfCycle(nums2, 0));
        int[] nums3 = {1, 2, 3, 1};

        //slow = Arr[0] = 1
        //fast = arr[arr[0]] = arr[1] = 2

        //slow = arr[1] =2
        //fast = arr[arr[2]] = arr[3] =1

        //slow = arr[2] = 3
        //fast = arr[arr[1]] = arr[2] =3



        System.out.println(lengthOfCycle(nums3, 0));
    }

    public static int lengthOfCycle(int[] arr, int startIndex) {

        if(arr.length==0 || arr==null){
            return -1;
        }
        int count =1;
        int slow = arr[startIndex];
        int fast = arr[arr[startIndex]];
        while(slow!=fast){
            if(arr[fast]>= arr.length || fast>=arr.length){
                return -1;
            }
            count++;
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        return count;
    }
}
