package com.suri.catest;

import java.util.ArrayList;
import java.util.List;

public class TestJune21 {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> integers = new ArrayList<>();
        for(int i=1; i<=100; i++){
            integers.add(i);
        }
        MyThread myThread = new MyThread(integers);
        System.out.println("start");
        myThread.start();
        System.out.println("end");

    }
}

class MyThread extends Thread{

    List<Integer> list;
    MyThread(List<Integer> list){
        this.list = list;
    }

    public void run(){
        synchronized (list) {
            int sum = 0;
            int i = 1;
            while (i <= 100) {
                sum +=list.get(i-1);
                i++;
            }
            System.out.println("sum = "+sum);
            list.notifyAll();
        }
    }
}
