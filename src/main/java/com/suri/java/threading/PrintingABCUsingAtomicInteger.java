package com.suri.java.threading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 */
public class PrintingABCUsingAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        new Student(ai, 1, "SAPIENT").start();
        new Student(ai, 2, "GLOBAL").start();
        new Student(ai, 0, "MARKETS").start();
    }

}

class Student extends Thread {
    AtomicInteger ai;
    int reminder;
    String c;

    Student(AtomicInteger a, int b, String c) {
        this.ai = a;
        this.reminder = b;
        this.c = c;
    }

    public void run() {
        while (true) {
            synchronized (ai) {
                int val = ai.intValue();
                if (val >= 10) {
                    ai.notifyAll();
                    break;
                } else {
                    if (val % 3 == reminder) {
                        System.out.println(" Thread " + reminder + " printing value " + c);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ai.getAndIncrement();
                        ai.notifyAll();
                    } else {
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