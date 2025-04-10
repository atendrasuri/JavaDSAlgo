package com.suri.catest.testTcs;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {

      /*
       //WAP

        String str = "java is a prgramming language";

        String strArr[] = str.split(" ");


       Arrays.stream(strArr).
                map(s -> s.replace(s.charAt(0), (char) (s.charAt(0)-32))).
               forEach(st-> System.out.println(st));
       */

        int arr[] = {32, 12, 56, 24, 75};




        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);


        for(int num :arr){
            priorityQueue.add(num);
        }
        if(priorityQueue.size()==1){
            System.out.println("There is only one number. So, second largest is not possible");
        }

        priorityQueue.remove();

        System.out.println("Second Largest = "+priorityQueue.remove());

    }
}
