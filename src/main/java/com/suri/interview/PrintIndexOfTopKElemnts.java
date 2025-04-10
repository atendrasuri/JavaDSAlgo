package com.suri.interview;

import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/05/19
 * @Description: (Overwrite)
 * Given N integers, print the index of K elements.
 * @History:
 */
public class PrintIndexOfTopKElemnts {

    public static void main(String[] args) {

        int arr[]={4,8,10,5,20,30,25};
        printTopKElements(arr,3);

    }

    public static void printTopKElements(int arr[], int k){

        if(arr.length==0){
            return;
        }

        int n= arr.length;

        PriorityQueue<Integer> queue= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            queue.add(arr[i]);
        }

        for(int i=k;i<n;i++){

            if(queue.peek()<arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}