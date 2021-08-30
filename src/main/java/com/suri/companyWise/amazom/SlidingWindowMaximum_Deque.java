package com.suri.companyWise.amazom;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SlidingWindowMaximum_Deque {

    public static void main(String[] args) {

        int [] arr = {1, 2, 3, 2, 4, 1, 5, 6, 1};
        int k = 3;

        slidingWindow(arr,k);
    }

    public static void slidingWindow(int arr[], int k) {

        Deque<Integer> dq = new LinkedList<>();


        //Step 1: handle first k elements in sliding window
        for (int i = 0; i < k; i++) {


            while (dq.isEmpty() == false && arr[dq.peekLast()] <= arr[i]) {
               int x= dq.removeLast();
                System.out.println(x);
            }

            dq.add(i);
        }

        //Step 2: handle rest of the element, one at a time nums[k] to nums[n-1]

        for (int i = k; i < arr.length; i++) {

            //before we do anything, print the first element in deque
            //since its a maximum among previous k elements
            System.out.print(arr[dq.peekFirst()] + " ");

            //Now remove the elements which are out for next window (next k elements)
            while (dq.isEmpty() == false && dq.peekFirst() <= i - k) {

                dq.removeFirst();
            }

            while (dq.isEmpty() == false && arr[dq.peekLast()] <= arr[i]) {

               dq.removeLast();


            }


            //add new element at the end
            dq.add(i);
        }

        System.out.print(arr[dq.peekFirst()] + " ");

    }


}