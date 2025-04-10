package com.suri.java.threading;
/*
Write a program using threads where first thread print from 11 and second thread print from 21
 Example [11,21,12,22 ...]
 */

import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreadPrintNumberOneByOne {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        PrintNumberOneByOne t1 = new PrintNumberOneByOne(ai, 1, 11);
        PrintNumberOneByOne t2 = new PrintNumberOneByOne(ai, 0, 21);
        t1.start();
        t2.start();

    }
}


class PrintNumberOneByOne extends Thread{

    private AtomicInteger ai;
    private Integer reminder;
    private Integer counter;

    PrintNumberOneByOne(AtomicInteger ai, Integer reminder, Integer counter){
        this.ai = ai;
        this.reminder=reminder;
        this.counter = counter;

    }

    public void run(){
        while (true) {
            synchronized (ai){
                int val = ai.intValue();
                if(val>=20){
                    ai.notifyAll();
                    break;
                }else{
                    if (val % 2 == reminder) {
                        System.out.println(" Thread " + reminder + " printing value "+counter++);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ai.getAndIncrement();
                        ai.notifyAll();
                    }else {
                        try {
                            ai.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
}
