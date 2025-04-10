package com.suri.interview;

import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/05/19
 * @Description: (Overwrite)
 * Given name of students in string array
 * and respective points in  integer array.
 *
 * task:- create a linked list behave similar to hashmap but if two keys are same then don't overwrite the value.
 *
 * INPUT:-
 * String s[]={"Zee", "Ani","Ani","Luh","Raj"};
 * int arr[]= {4,6,8,10,20};
 *
 * OUTPUT:-
 * Zee --> 4
 * Ani---> 6
 * Luh---->10
 * Raj----> 20
 *
 */
public class CreateLinkedListLikeHashMap {


    public static void main(String args[]){

        String s[]={"Zee", "Ani","Ani","Luh","Raj"};
        int arr[]= {4,6,8,10,20};
        int n=5;

        PriorityQueue<Integer> queue= new PriorityQueue<>();
        queue.add(arr[0]);
        queue.add(arr[1]);
        queue.add(arr[2]);

        for(int i=3;i<n;i++){

            if(queue.peek()<arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }


        }

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.poll();
        }
//        create(n,s,ar);
//        print();

    }

    static class Node{
        String key;
        int val;
        Node next;

        Node(String key, int val){
            this.key=key;
            this.val=val;
            next=null;
        }
    }

    static Node start=null;


    public static void create(int n, String s[], int ar[]){

        start= new Node(s[0],ar[0]);
        Node temp=start;

        for(int i=1;i<n;){

            if(temp.key.equals(s[i])){
                i++;
            }else{
                temp.next= new Node(s[i],ar[i]);
                temp= temp.next;
                i++;
            }

        }
    }

    public static void print(){
        Node temp=start;

        while(temp!=null){
            System.out.println(temp.key+" "+temp.val);
            temp=temp.next;
        }
    }
}